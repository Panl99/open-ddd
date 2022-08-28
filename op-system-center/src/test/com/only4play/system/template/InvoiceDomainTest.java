package com.only4play.system.template;

import com.only4play.system.domain.invoice.orderreceipt.domainservice.IOrderReceiptDomainService;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class InvoiceDomainTest {


  @Autowired
  private IOrderReceiptDomainService orderReceiptDomainService;


  /**
   * 测试订单注册
   */
  @Test
  public void testOrderRegister(){
    OrderRegisterModel registerModel = new OrderRegisterModel();
    OrderRegisterResultModel result = orderReceiptDomainService.orderRegister(
        registerModel);
    System.out.println(result);
  }

  /**
   * 测试开票
   */
  @Test
  public void testExchangeInvoice(){
    ExchangeInvoiceModel exchangeInvoiceModel = new ExchangeInvoiceModel();
    orderReceiptDomainService.exchangeInvoice(exchangeInvoiceModel);
  }

}
