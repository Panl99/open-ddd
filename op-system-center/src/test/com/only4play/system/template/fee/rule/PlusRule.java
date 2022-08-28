package com.only4play.system.template.fee.rule;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public class PlusRule extends AbstractFeeRule{

  @Setter
  @Getter
  private String cardNo;

  public PlusRule(BigDecimal configValue,
      FeeRuleType ruleType, Integer order) {
    super(configValue, ruleType, order);
  }
}
