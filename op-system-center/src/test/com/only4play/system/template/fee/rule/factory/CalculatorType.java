package com.only4play.system.template.fee.rule.factory;

import com.only4play.common.constants.BaseEnum;
import com.only4play.order.commons.fee.Unique;
import java.util.Optional;

public enum CalculatorType implements BaseEnum<CalculatorType>, Unique {

  FREE_TIME(1, "免费时长"),
  FREE_TIMES(2,"免费次数"),
  PLUS_DISCOUNT(3,"会员打折"),
  MAX_LIMIT(4,"最大限额")
  ;

  CalculatorType(Integer code, String name) {
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

  public static Optional<CalculatorType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(CalculatorType.class, code));
  }

  @Override
  public Integer getUniqueCode() {
    return this.code;
  }
}