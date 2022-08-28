package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register;

import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.system.domain.invoice.enterpriseentity.vo.EnterpriseEntityVO;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.OrderReceiptContext;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import com.only4play.system.infrastructure.model.CodeValue;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 根据订单信息找到交易的企业
 */
@RequiredArgsConstructor
@Slf4j
public class EnterpriseRouterFilter extends AbstractOrderFilter<OrderReceiptContext> {

  private final IInvoicePipeLineFacadeService invoicePipeLineFacadeService;

  @Override
  protected void handle(OrderReceiptContext orderReceiptContext) {
    List<CodeValue> orderAttrs = orderReceiptContext.getModel().getOrderAttrs();
    EnterpriseEntityVO vo = invoicePipeLineFacadeService.getInvoiceFacadeService()
        .orderRouter2TaxCode(orderAttrs);
    orderReceiptContext.getRegisterResultModel().setTaxCode(vo.getTaxCode());
  }
}
