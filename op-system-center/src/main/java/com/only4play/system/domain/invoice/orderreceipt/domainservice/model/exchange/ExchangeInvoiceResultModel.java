package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import java.util.List;
import lombok.Data;

/**
 * 开票结果模型
 */
@Data
public class ExchangeInvoiceResultModel {

  @FieldDesc(name = "发票列表")
  private List<InvoiceModel> invoiceList;

}
