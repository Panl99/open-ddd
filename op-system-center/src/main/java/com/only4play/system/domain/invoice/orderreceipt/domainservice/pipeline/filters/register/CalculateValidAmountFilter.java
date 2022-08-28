package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.collection.ListUtil;
import com.only4play.common.constants.ValidStatus;
import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.order.commons.pay.PayType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.OrderReceiptContext;
import com.only4play.system.domain.invoice.payitemconfig.vo.PayItemConfigVO;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 计算有效金额和计算无效金额的过滤器
 */
@RequiredArgsConstructor
@Slf4j
public class CalculateValidAmountFilter extends AbstractOrderFilter<OrderReceiptContext> {

  private final IInvoicePipeLineFacadeService pipeLineFacadeService;

  @Override
  protected void handle(OrderReceiptContext orderReceiptContext) {
    OrderRegisterModel model = orderReceiptContext.getModel();
    //所有的支付项
    List<PayItem> payItems = model.getPayItemList();
    List<PayItemConfigVO> vos = pipeLineFacadeService.getInvoiceFacadeService()
        .getPayItemConfigs(model.getTradeTypeCode());
    //通过找到不可以开票的项
    List<PayType> invalidList = vos.stream()
        .filter(v -> Objects.equals(ValidStatus.INVALID, v.getValidStatus()))
        .map(e -> e.getPayType())
        .collect(Collectors.toList());
    if(IterUtil.isNotEmpty(invalidList)){
      //找到不可以开票的项
      List<PayItem> invalidItems = payItems.stream()
          .filter(v -> invalidList.contains(v.getPayType()))
          .collect(Collectors.toList());
      orderReceiptContext.getRegisterResultModel().setInvalidList(invalidItems);
      orderReceiptContext.getRegisterResultModel().setValidList(ListUtil.toList(CollectionUtil.subtract(payItems,invalidItems)));
    }else{
      orderReceiptContext.getRegisterResultModel().setInvalidList(Collections.emptyList());
      orderReceiptContext.getRegisterResultModel().setValidList(payItems);
    }
  }
}
