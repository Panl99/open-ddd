package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceStyle;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.CustomerModel;
import lombok.Data;

/**
 * 根据实际业务进行查询开票
 */
@Data
public class ExchangeConditionModel {

  private String tradeType;

  private String phone;

  private InvoiceStyle invoiceStyle;

  private InvoiceType invoiceType;

  @FieldDesc(name = "是否为预览")
  private boolean preview;

  /**
   * 购方信息
   */
  private CustomerModel customerModel;

}
