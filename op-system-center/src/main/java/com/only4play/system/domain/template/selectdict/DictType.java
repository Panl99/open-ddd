package com.only4play.system.domain.template.selectdict;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum DictType implements BaseEnum<DictType> {

  SELECT_LIST(1, "下拉列表"),
  HTTP_INVOKE(2,"http调用")
  ;

  DictType(Integer code, String name) {
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

  public static Optional<DictType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(DictType.class, code));
  }

}
