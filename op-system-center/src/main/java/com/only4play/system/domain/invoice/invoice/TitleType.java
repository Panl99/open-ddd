package com.only4play.system.domain.invoice.invoice;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * title 类型
 */
public enum TitleType implements BaseEnum<TitleType> {

  PERSONAL(1, "个人"),
  ENTERPRISE(2,"企业")
  ;

  TitleType(Integer code, String name) {
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

  public static Optional<TitleType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(TitleType.class, code));
  }

}