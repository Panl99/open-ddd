package com.only4play.system.domain.invoice.invoice.events;

import com.only4play.system.domain.invoice.invoice.Invoice;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.InvoiceModel;
import lombok.Value;

public interface InvoiceEvents {

  @Value
  class InvoiceCreateEvent {

    private Invoice invoice;
    private ExchangeInvoiceModel exchangeInvoiceModel;
    private InvoiceModel invoiceModel;

  }

}
