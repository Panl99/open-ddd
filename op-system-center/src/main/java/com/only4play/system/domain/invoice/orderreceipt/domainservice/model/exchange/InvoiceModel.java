package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.system.infrastructure.elastic.OrderReceiptDocument;
import java.util.List;
import lombok.Data;

@Data
public class InvoiceModel {

  /**
   * 发票项信息
   */
  private List<InvoiceItemModel> itemList;

  /**
   *
   */
  private SellerModel sellerModel;

  /**
   * 操作人信息
   */
  private OperateUserModel operateUserModel;

  /**
   * 第几张发票
   */
  private Integer indexNo;

  /**
   * 订单信息
   */
  private List<OrderReceiptDocument> receiptDocuments;



}
