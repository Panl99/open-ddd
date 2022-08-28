package com.only4play.system.template.fee.rule;

import java.math.BigDecimal;

public class AbstractFeeRule implements FeeRule{

  private final BigDecimal configValue;
  private final FeeRuleType ruleType;
  private final Integer order;

  public AbstractFeeRule(BigDecimal configValue,
      FeeRuleType ruleType, Integer order) {
    this.configValue = configValue;
    this.ruleType = ruleType;
    this.order = order;
  }

  @Override
  public BigDecimal getConfigValue() {
    return configValue;
  }

  @Override
  public FeeRuleType getRuleType() {
    return ruleType;
  }

  @Override
  public Integer getOrder() {
    return order;
  }
}
