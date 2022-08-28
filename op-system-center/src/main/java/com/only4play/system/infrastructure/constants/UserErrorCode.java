package com.only4play.system.infrastructure.constants;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum UserErrorCode implements BaseEnum<UserErrorCode> {

  xxx(1301000, "name");

  UserErrorCode(Integer code, String name) {
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

  public static Optional<UserErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(UserErrorCode.class, code));
  }

}
