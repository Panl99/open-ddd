package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context;

import com.only4play.order.commons.constants.BizEnum;
import com.only4play.order.commons.filters.selector.FilterSelector;
import com.only4play.order.commons.model.AbstractOrderContext;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceResultModel;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocument;
import io.vavr.Tuple2;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * 换票上下文
 */
public class ExchangeInvoiceContext extends AbstractOrderContext {

  @Getter
  @Setter
  private ExchangeInvoiceModel exchangeInvoiceModel;

  @Getter
  @Setter
  private ExchangeInvoiceResultModel resultModel;

  /**
   * 存放拆票结果
   */
  @Getter
  @Setter
  private List<Tuple2<String, Map<Integer, List<OrderReceiptDocument>>>> splitResult;

  public ExchangeInvoiceContext(BizEnum bizEnum,
      FilterSelector selector) {
    super(bizEnum, selector);
  }

  @Override
  public boolean continueChain() {
    return true;
  }
}
