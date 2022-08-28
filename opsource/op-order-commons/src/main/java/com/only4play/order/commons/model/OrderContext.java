package com.only4play.order.commons.model;

import com.only4play.order.commons.constants.BizEnum;
import com.only4play.order.commons.filters.selector.FilterSelector;

/**
 * @author gim
 */
public interface OrderContext{

  /**
   * 获取业务编码
   * @return
   */
  BizEnum getBizCode();

  /**
   * 获取过滤器选择器
   * @return
   */
  FilterSelector getFilterSelector();

  /**
   * 是否继续链
   * @return
   */
  boolean continueChain();



}
