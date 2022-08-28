package com.only4play.order.commons.filters;


import com.only4play.order.commons.model.OrderContext;

/**
 * @author gim
 */
public abstract class AbstractOrderFilter<T extends OrderContext> implements OrderFilter<T> {

  @Override
  public void doFilter(T context, OrderFilterChain chain) {
    if (context.getFilterSelector().matchFilter(this.getClass().getSimpleName())) {
      handle(context);
    }
    if (context.continueChain()) {
      chain.fireNext(context);
    }
  }

  protected abstract void handle(T context);
}
