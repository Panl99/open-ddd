package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange;

import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.ExchangeInvoiceContext;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocument;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import io.vavr.Tuple2;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class SplitAmountFilter extends AbstractOrderFilter<ExchangeInvoiceContext> {

  private final IInvoicePipeLineFacadeService invoicePipeLineFacadeService;

  @Override
  protected void handle(ExchangeInvoiceContext context) {
    log.info("进行凭据拆票");
    List<Tuple2<String, Map<Integer, List<OrderReceiptDocument>>>> list = invoicePipeLineFacadeService.getInvoiceFacadeService()
        .splitInvoice(context);
    //拆票结果放入上下文
    context.setSplitResult(list);
  }
}
