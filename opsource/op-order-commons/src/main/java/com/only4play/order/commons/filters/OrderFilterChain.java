package com.only4play.order.commons.filters;


import com.only4play.order.commons.model.OrderContext;

/**
 * @author gim
 */
public interface OrderFilterChain<T extends OrderContext> {


  /**
   * 订单上送支付处理流程
   * @param context
   */
  void handle(T context);

  /**
   * 开启下一个鉴权
   * @param ctx
   */
  void fireNext(T ctx);

}
