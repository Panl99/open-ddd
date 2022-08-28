package com.only4play.system.infrastructure.constants;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum TemplateErrorCode implements BaseEnum<TemplateErrorCode> {

  INPUT_TOO_BIG(1401001, "输入值过大"),
  INPUT_TOO_SMALL(1401002,"输入值过小"),
  FORMAT_ERROR(1401003,"格式错误"),
  INPUT_TOO_LONG(1401004,"输入文字太长"),
  CODE_EXIST(1401005,"编码已经存在");

  TemplateErrorCode(Integer code, String name) {
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

  public static Optional<TemplateErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(TemplateErrorCode.class, code));
  }

}
