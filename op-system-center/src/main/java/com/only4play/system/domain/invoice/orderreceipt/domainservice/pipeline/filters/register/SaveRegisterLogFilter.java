package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register;

import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.OrderReceiptContext;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 保存注册请求到日志或者发送到mq 异步保存，用于故障修复
 */
@RequiredArgsConstructor
@Slf4j
public class SaveRegisterLogFilter extends AbstractOrderFilter<OrderReceiptContext> {

  private final IInvoicePipeLineFacadeService pipeLineFacadeService;

  @Override
  protected void handle(OrderReceiptContext orderReceiptContext) {

    log.info("执行保存注册请求体:{}",SaveRegisterLogFilter.class.getSimpleName());

  }
}
