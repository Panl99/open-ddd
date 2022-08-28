package com.only4play.system.template.fee.rule;

import java.math.BigDecimal;

public class FreeTimeRule extends AbstractFeeRule{

  public FreeTimeRule(BigDecimal configValue,
      FeeRuleType ruleType, Integer order) {
    super(configValue, ruleType, order);
  }
}
