package com.only4play.order.commons.model;


import com.only4play.order.commons.constants.BizEnum;
import com.only4play.order.commons.filters.selector.FilterSelector;

/**
 * @author gim
 */
public abstract class AbstractOrderContext implements OrderContext{

  private final BizEnum bizEnum;
  private final FilterSelector selector;

  public AbstractOrderContext(BizEnum bizEnum, FilterSelector selector) {
    this.bizEnum = bizEnum;
    this.selector = selector;
  }

  @Override
  public BizEnum getBizCode() {
    return bizEnum;
  }

  @Override
  public FilterSelector getFilterSelector() {
    return selector;
  }
}
