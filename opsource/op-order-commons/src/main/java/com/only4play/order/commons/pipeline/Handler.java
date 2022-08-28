package com.only4play.order.commons.pipeline;

/**
 * @author gim
 */
public interface Handler<I, O> {

  /**
   * 处理I 返回O
   *
   * @param input
   * @return
   */
  O process(I input);

}
