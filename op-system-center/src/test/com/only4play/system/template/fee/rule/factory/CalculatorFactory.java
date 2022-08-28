package com.only4play.system.template.fee.rule.factory;

import com.only4play.order.commons.fee.FeeCalculate;
import com.only4play.system.template.fee.rule.FeeRule;
import com.only4play.system.template.fee.rule.FeeRuleType;
import com.only4play.system.template.fee.rule.FreeTimeRule;
import com.only4play.system.template.fee.rule.FreeTimesRule;
import com.only4play.system.template.fee.rule.calculator.FreeTimeCalculator;
import com.only4play.system.template.fee.rule.calculator.FreeTimesCalculator;
import com.only4play.system.template.fee.rule.calculator.MaxLimitCalculator;
import com.only4play.system.template.fee.rule.calculator.PlusRuleCalculator;
import java.util.Objects;


public class CalculatorFactory {

  public static FeeCalculate getFeeCalculateByRuleType(FeeCalculate calculate, FeeRule rule) {
    if (Objects.equals(FeeRuleType.FREE_TIME, rule.getRuleType())) {
      FreeTimeRule time = (FreeTimeRule) rule;//这里可以强制转化
      return new FreeTimeCalculator(calculate, CalculatorType.FREE_TIME, time.getConfigValue().intValue());
    } else if (Objects.equals(FeeRuleType.FREE_TIMES, rule.getRuleType())) {
      FreeTimesRule timesRule = (FreeTimesRule) rule;
      return new FreeTimesCalculator(calculate, CalculatorType.FREE_TIMES, timesRule.getConfigValue().intValue());
    } else if (Objects.equals(FeeRuleType.PLUS_RULE, rule.getRuleType())) {
      //不需要可以不转
      return new PlusRuleCalculator(calculate, CalculatorType.PLUS_DISCOUNT, rule.getConfigValue());
    } else if (Objects.equals(FeeRuleType.MAX_LIMIT, rule.getRuleType())) {
      return new MaxLimitCalculator(calculate, CalculatorType.MAX_LIMIT, rule.getConfigValue());
    }
    return null;
  }


}
