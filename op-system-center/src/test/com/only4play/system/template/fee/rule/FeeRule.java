package com.only4play.system.template.fee.rule;

import java.math.BigDecimal;

public interface FeeRule {

  /**
   * 获取配置的数值
   * @return
   */
  BigDecimal getConfigValue();

  /**
   * 获取规则类型
   * @return
   */
  FeeRuleType getRuleType();

  /**
   * 规则的顺序
   * @return
   */
  Integer getOrder();

}
