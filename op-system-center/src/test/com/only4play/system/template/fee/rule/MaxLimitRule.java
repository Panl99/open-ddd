package com.only4play.system.template.fee.rule;

import java.math.BigDecimal;

public class MaxLimitRule extends AbstractFeeRule{

  public MaxLimitRule(BigDecimal configValue,
      FeeRuleType ruleType, Integer order) {
    super(configValue, ruleType, order);
  }
}
