package com.only4play.order.commons.test.fee;

import com.only4play.common.constants.BaseEnum;
import com.only4play.order.commons.fee.Unique;
import java.util.Optional;

/**
 * @author gim 2021/12/6 8:40 下午
 */
public enum CalculateType implements BaseEnum<CalculateType> , Unique {

  COUPON(1, "优惠劵计算器"),
  ACTIVITY(2,"活动计算器");

  CalculateType(Integer code, String name) {
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

  public static Optional<CalculateType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(CalculateType.class, code));
  }

  @Override
  public Integer getUniqueCode() {
    return this.code;
  }
}
