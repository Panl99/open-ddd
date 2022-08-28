package com.only4play.order.commons.filters.selector;


import com.only4play.order.commons.constants.BizEnum;

/**
 * @author gim
 */
public interface BizAware {

  /**
   * 获取当前业务编码
   * @return
   */
  BizEnum getBizCode();
}
