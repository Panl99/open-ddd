package com.only4play.system.domain.message;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum SmsType implements BaseEnum<SmsType> {

  LOGIN(1, "登录"),
  FIND_PASS(2,"找回密码")
  ;

  SmsType(Integer code, String name) {
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

  public static Optional<SmsType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(SmsType.class, code));
  }

}
