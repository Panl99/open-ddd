package com.only4play.system.domain.invoice.orderreceipt.events;

import com.only4play.system.domain.invoice.orderreceipt.OrderReceipt;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceResultModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel;
import lombok.Value;

public interface OrderReceiptEvents {

  @Value
  class OrderRegisterEvent {

    private OrderReceipt orderReceipt;
    private OrderRegisterModel orderRegisterModel;
    private OrderRegisterResultModel registerResultModel;
  }

}
