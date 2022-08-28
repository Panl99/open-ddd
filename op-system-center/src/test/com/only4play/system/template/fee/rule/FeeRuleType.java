package com.only4play.system.template.fee.rule;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum FeeRuleType implements BaseEnum<FeeRuleType> {

  FREE_TIMES(1, "免费次数"),
  FREE_TIME(2,"免费时长规则"),
  PLUS_RULE(3,"plus会员规则"),
  MAX_LIMIT(4,"限额规则")
  ;

  FeeRuleType(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  private Integer code;
  private String name;

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public static Optional<FeeRuleType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(FeeRuleType.class, code));
  }

}
