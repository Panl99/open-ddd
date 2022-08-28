package com.only4play.order.commons.fee;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * @author gim
 */
public enum FeeItemType implements BaseEnum<FeeItemType> {

  SERVICE_FEE(1, "服务费"),
  ELECTRIC_FEE(2,"电费"),
  OVER_WEIGHT_FEE(3,"超重费"),
  OVER_TIME_FEE(4,"超时费")
  ;

  FeeItemType(Integer code, String name) {
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

  public static Optional<FeeItemType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(FeeItemType.class, code));
  }

}
