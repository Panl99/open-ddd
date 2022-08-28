package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange;

import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.ExchangeInvoiceContext;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 填充票面信息
 */
@Slf4j
@RequiredArgsConstructor
public class PopulateInvoiceFilter extends AbstractOrderFilter<ExchangeInvoiceContext> {

  private final IInvoicePipeLineFacadeService invoicePipeLineFacadeService;

  @Override
  public void handle(ExchangeInvoiceContext context) {
    invoicePipeLineFacadeService.getInvoiceFacadeService().populateInvoice(context);
  }
}
