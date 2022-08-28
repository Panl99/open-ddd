package com.only4play.system.domain.trade.order.domainservice;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.NumberUtil;
import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.trade.order.OrderBase;
import com.only4play.system.domain.trade.order.QOrderBase;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCompleteModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCreateModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderReviseModel;
import com.only4play.system.domain.trade.order.mapper.OrderBaseMapper;
import com.only4play.system.domain.trade.order.repository.OrderBaseRepository;
import com.only4play.system.infrastructure.facade.IFlowNoFacade;
import com.querydsl.core.BooleanBuilder;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDomainServiceImpl implements IOrderDomainService{

  private final OrderBaseRepository orderBaseRepository;

  private final IFlowNoFacade flowNoFacade;

  @Override
  public boolean orderCreate(OrderCreateModel createModel) {
    Assert.notEmpty(createModel.getItemInfoList());
    BigDecimal itemTotal = createModel.getItemInfoList().stream().map(p -> p.getRealAmount())
        .reduce(BigDecimal.ZERO, (a, b) -> (NumberUtil.add(a, b)));
    Long flowNo = flowNoFacade.getNextId();
    OrderBase orderBase = OrderBaseMapper.INSTANCE.model2Entity(createModel);
    orderBase.setFlowNo(flowNo);
    orderBase.setTotalAmount(itemTotal);
    EntityOperations
        .doCreate(orderBaseRepository)
        .create(() -> orderBase)
        .update(e -> e.init(createModel))
        .execute();
    return true;
  }

  @Override
  public boolean orderRevise(OrderReviseModel reviseModel) {

    return true;
  }

  @Override
  public boolean orderComplete(OrderCompleteModel completeModel) {
    BooleanBuilder bb = new BooleanBuilder().and(QOrderBase.orderBase.flowNo.eq(completeModel.getFlowNo()));
    Optional<OrderBase> order = orderBaseRepository.findOne(bb);
    if(!order.isPresent()){
      throw new BusinessException(CodeEnum.NotFindError);
    }
    EntityOperations
        .doUpdate(orderBaseRepository)
        .load(() -> order.get())
        .update(e -> e.complete(completeModel))
        .execute();
    return true;
  }

  @Override
  public boolean orderCancel(Long flowNo) {
    BooleanBuilder bb = new BooleanBuilder().and(QOrderBase.orderBase.flowNo.eq(flowNo));
    Optional<OrderBase> order = orderBaseRepository.findOne(bb);
    if(!order.isPresent()){
      throw new BusinessException(CodeEnum.NotFindError);
    }
    EntityOperations
        .doUpdate(orderBaseRepository)
        .load(() -> order.get())
        .update(e -> e.cancel())
        .execute();
    return true;
  }
}
