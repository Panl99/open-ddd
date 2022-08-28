package com.only4play.order.commons.filters;


import com.only4play.order.commons.model.OrderContext;

/**
 * @author gim
 */
public interface OrderFilter<T extends OrderContext> {

  /**
   * 过滤逻辑封装点
   *
   * @param context
   * @param chain
   */
  void doFilter(T context, OrderFilterChain chain);


}
