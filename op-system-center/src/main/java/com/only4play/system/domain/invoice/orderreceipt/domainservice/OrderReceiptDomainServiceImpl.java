package com.only4play.system.domain.invoice.orderreceipt.domainservice;

import com.only4play.order.commons.constants.BizEnum;
import com.only4play.order.commons.filters.selector.FilterSelector;
import com.only4play.order.commons.filters.selector.LocalListBasedFilterSelector;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeConditionModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceResultModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.FilterChainPipeline;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.ExchangeInvoiceContext;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.OrderReceiptContext;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.InputCheckFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.PopulateInvoiceFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.SaveExchangeLogFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.SplitAmountFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.CalculateValidAmountFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.EnterpriseRouterFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.PopulateReceiptItemFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.SaveRegisterLogFilter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderReceiptDomainServiceImpl implements IOrderReceiptDomainService {

  private final FilterChainPipeline orderRegisterPipeline;

  private final FilterChainPipeline exchangeInvoicePipeline;


  @Override
  public OrderRegisterResultModel orderRegister(OrderRegisterModel registerModel) {
    //??????????????????filter
    FilterSelector selector = getOrderRegisterSelector();
    //???????????????
    OrderReceiptContext orderReceiptContext = new OrderReceiptContext(BizEnum.BIZ_XXX, selector);
    //??????????????????????????????
    orderReceiptContext.setModel(registerModel);
    //??????????????????bean
    OrderRegisterResultModel resultModel = new OrderRegisterResultModel();
    orderReceiptContext.setRegisterResultModel(resultModel);
    orderRegisterPipeline.getFilterChain().handle(orderReceiptContext);
    return orderReceiptContext.getRegisterResultModel();
  }

  @Override
  public boolean receiptAbandon(List<Long> ids) {
    return false;
  }

  /**
   * ??????????????????
   * @param exchangeInvoiceModel
   * @return
   */
  @Override
  public ExchangeInvoiceResultModel exchangeInvoice(
      ExchangeInvoiceModel exchangeInvoiceModel) {
    FilterSelector selector = getExchangeSelector();
    ExchangeInvoiceContext invoiceContext = new ExchangeInvoiceContext(BizEnum.BIZ_XXX, selector);
    invoiceContext.setExchangeInvoiceModel(exchangeInvoiceModel);
    ExchangeInvoiceResultModel resultModel = new ExchangeInvoiceResultModel();
    invoiceContext.setResultModel(resultModel);
    exchangeInvoicePipeline.getFilterChain().handle(invoiceContext);
    return invoiceContext.getResultModel();
  }

  @Override
  public ExchangeInvoiceResultModel exchangeInvoiceByCondition(
      ExchangeConditionModel conditionModel) {
    return null;
  }

  @Override
  public void completeInvoice(List<Long> ids) {

  }


  /**
   * ?????????????????????filter
   * @return
   */
  private FilterSelector getOrderRegisterSelector() {
    LocalListBasedFilterSelector selector = new LocalListBasedFilterSelector();
    selector.addFilter(CalculateValidAmountFilter.class.getSimpleName());
    selector.addFilter(SaveRegisterLogFilter.class.getSimpleName());
    selector.addFilter(PopulateReceiptItemFilter.class.getSimpleName());
    selector.addFilter(EnterpriseRouterFilter.class.getSimpleName());
    return selector;
  }

  /**
   * ????????????????????????filter
   * @return
   */
  private FilterSelector getExchangeSelector() {
    LocalListBasedFilterSelector selector = new LocalListBasedFilterSelector();
    selector.addFilter(SaveExchangeLogFilter.class.getSimpleName());
    selector.addFilter(SplitAmountFilter.class.getSimpleName());
    selector.addFilter(InputCheckFilter.class.getSimpleName());
    selector.addFilter(PopulateInvoiceFilter.class.getSimpleName());
    return selector;
  }
}
