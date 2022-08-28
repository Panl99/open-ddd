package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context;

import com.only4play.order.commons.constants.BizEnum;
import com.only4play.order.commons.filters.selector.FilterSelector;
import com.only4play.order.commons.model.AbstractOrderContext;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 注册凭据上下文
 */
public class OrderReceiptContext extends AbstractOrderContext {

  private boolean continueFlag = true;

  private boolean preview;

  @Setter
  @Getter
  private OrderRegisterModel model;

  /**
   * 注册
   */
  @Setter
  @Getter
  private OrderRegisterResultModel registerResultModel;


  public OrderReceiptContext(BizEnum bizEnum, FilterSelector selector) {
    super(bizEnum, selector);
  }

  @Override
  public boolean continueChain() {
    return continueFlag;
  }
}
