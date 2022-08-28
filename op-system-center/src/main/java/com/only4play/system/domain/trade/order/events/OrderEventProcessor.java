package com.only4play.system.domain.trade.order.events;

import com.only4play.system.domain.trade.order.OrderBase;
import com.only4play.system.domain.trade.order.domainservice.model.OrderItemModel;
import com.only4play.system.domain.trade.order.events.OrderEvents.OrderCancelEvent;
import com.only4play.system.domain.trade.order.events.OrderEvents.OrderCreateEvent;
import com.only4play.system.domain.trade.order.mapper.OrderBaseMapper;
import com.only4play.system.domain.trade.orderitem.creator.OrderItemCreator;
import com.only4play.system.domain.trade.orderitem.mapper.OrderItemMapper;
import com.only4play.system.domain.trade.orderitem.service.IOrderItemService;
import com.only4play.system.domain.trade.orderlifecycle.OrderOperateType;
import com.only4play.system.domain.trade.orderlifecycle.creator.OrderLifecycleCreator;
import com.only4play.system.domain.trade.orderlifecycle.service.IOrderLifecycleService;
import com.only4play.system.infrastructure.elastic.OrderDocument;
import com.only4play.system.infrastructure.elastic.OrderDocumentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventProcessor {

  private final IOrderItemService orderItemService;

  private final IOrderLifecycleService orderLifecycleService;

  private final OrderDocumentRepository orderDocumentRepository;

  @EventListener
  public void handleOrderCreateForEs(OrderCreateEvent createEvent){
    OrderBase orderBase = createEvent.getOrderBase();
    OrderDocument document = OrderBaseMapper.INSTANCE.entity2Document(orderBase);
    document.setId(String.valueOf(orderBase.getFlowNo()));
    document.setOrderStatusTxt(orderBase.getOrderState().getName());
    document.setOrderTypeTxt(orderBase.getOrderType().getName());
    document.setOrderItems(createEvent.getCreateModel().getItemInfoList());
    orderDocumentRepository.save(document);
  }

  @EventListener
  public void handleOrderCancelForEs(OrderCancelEvent orderCancelEvent){

  }

  @EventListener
  public void handleOrderCreateForItem(OrderCreateEvent orderCreateEvent){
    List<OrderItemModel> itemInfoList = orderCreateEvent.getCreateModel().getItemInfoList();
    itemInfoList.stream().forEach(model -> {
      OrderItemCreator creator = OrderItemMapper.INSTANCE.model2Creator(model);
      creator.setOrderId(orderCreateEvent.getOrderBase().getId());
      creator.setFlowNo(orderCreateEvent.getOrderBase().getFlowNo());
      orderItemService.createOrderItem(creator);
    });
  }

  @EventListener
  public void handleOrderCreateForLifecycle(OrderCreateEvent createEvent){
    OrderLifecycleCreator creator = new OrderLifecycleCreator();
    creator.setFlowNo(createEvent.getOrderBase().getFlowNo());
    creator.setOperateType(OrderOperateType.ORDER_CREATE);
    creator.setOperateUser(createEvent.getCreateModel().getOperateUser());
    creator.setRemark("订单创建成功");
    orderLifecycleService.createOrderLifecycle(creator);
  }


}
