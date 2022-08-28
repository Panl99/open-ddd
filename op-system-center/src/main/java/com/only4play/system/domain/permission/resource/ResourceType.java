package com.only4play.system.domain.permission.resource;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum ResourceType implements BaseEnum<ResourceType> {

  MODULE(1, "模块"),
  MENU(2, "菜单"),
  FUNC(3, "功能");

  ResourceType(Integer code, String name) {
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

  public static Optional<ResourceType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(ResourceType.class, code));
  }

}