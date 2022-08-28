// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.orderreceipt.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.query.OrderReceiptQuery;
import com.only4play.system.domain.invoice.orderreceipt.updater.OrderReceiptUpdater;
import com.only4play.system.domain.invoice.orderreceipt.vo.OrderReceiptVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface IOrderReceiptService {
  /**
   * 注册凭据
   */
  Long createOrderReceipt(OrderRegisterModel model);


  void exchangeInvoice(ExchangeInvoiceModel exchangeInvoiceModel);
  /**
   * update
   */
  void updateOrderReceipt(OrderReceiptUpdater updater);

  /**
   * valid
   */
  void validOrderReceipt(Long id);

  /**
   * invalid
   */
  void invalidOrderReceipt(Long id);

  /**
   * findById
   */
  OrderReceiptVO findById(Long id);

  /**
   * findByPage
   */
  Page<OrderReceiptVO> findByPage(PageRequestWrapper<OrderReceiptQuery> query);
}
