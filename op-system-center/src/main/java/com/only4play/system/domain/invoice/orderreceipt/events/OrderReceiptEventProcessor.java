package com.only4play.system.domain.invoice.orderreceipt.events;

import com.only4play.system.domain.invoice.orderreceipt.OrderReceipt;
import com.only4play.system.domain.invoice.orderreceipt.creator.ReceiptItemCreator;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel.ReceiptItemModel;
import com.only4play.system.domain.invoice.orderreceipt.events.OrderReceiptEvents.OrderRegisterEvent;
import com.only4play.system.domain.invoice.orderreceipt.mapper.OrderReceiptMapper;
import com.only4play.system.domain.invoice.orderreceipt.mapper.ReceiptItemMapper;
import com.only4play.system.domain.invoice.orderreceipt.service.IReceiptItemService;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocument;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocumentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderReceiptEventProcessor {

  private final IReceiptItemService receiptItemService;

  private final OrderReceiptDocumentRepository orderReceiptDocumentRepository;


  /**
   * 保存到ES  CQRS架构，解决各个维度的订单查询问题
   * @param orderRegisterEvent
   */
  @EventListener
  public void handleOrderRegisterEventForEs(OrderRegisterEvent orderRegisterEvent){

    OrderReceipt orderReceipt = orderRegisterEvent.getOrderReceipt();
    OrderReceiptDocument document = OrderReceiptMapper.INSTANCE.entity2Document(
        orderReceipt);
    //id 不用数据库id,用唯一流水号
    document.setId(String.valueOf(orderReceipt.getRegisterFlowNo()));
    document.setReceiptItemModels(orderRegisterEvent.getRegisterResultModel().getItems());
    orderReceiptDocumentRepository.save(document);
  }

  /**
   * 保存凭据项
   * 这里呢，可以写个批量，也可以独立存，看需求，一般订单项不会太多foreach 就行了
   */
  @EventListener
  public void handleRegisterEventForItem(OrderRegisterEvent orderRegisterEvent){
    List<ReceiptItemModel> items = orderRegisterEvent.getRegisterResultModel().getItems();
    List<ReceiptItemCreator> creators = items.stream()
        .map(item -> {
          ReceiptItemCreator itemCreator = ReceiptItemMapper.INSTANCE.model2Creator(item);
          itemCreator.setReceiptId(orderRegisterEvent.getOrderReceipt().getId());
          return itemCreator;
        })
        .collect(Collectors.toList());
    receiptItemService.batchCreateReceiptItems(creators);
  }

}
