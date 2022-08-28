package com.only4play.system.domain.invoice.orderreceipt.domainservice;

import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeConditionModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceResultModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel;
import java.util.List;

/**
 * 凭据领域服务层
 */
public interface IOrderReceiptDomainService {

  /**
   * 注册凭据
   */
  OrderRegisterResultModel orderRegister(OrderRegisterModel registerModel);

  /**
   * 凭据作废
   */
  boolean receiptAbandon(List<Long> ids);

  /**
   * 开票==换取发票
   */
  ExchangeInvoiceResultModel exchangeInvoice(ExchangeInvoiceModel exchangeInvoiceModel);

  /**
   * 根据条件开票
   */
  ExchangeInvoiceResultModel exchangeInvoiceByCondition(ExchangeConditionModel conditionModel);

  /**
   * 开票完成
   */
  void completeInvoice(List<Long> ids);

}
