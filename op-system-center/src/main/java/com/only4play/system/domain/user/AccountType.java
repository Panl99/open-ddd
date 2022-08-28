package com.only4play.system.domain.user;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum AccountType implements BaseEnum<AccountType> {

  PERSONAL(1, "个人"),
  CORP(2,"企业")
  ;

  AccountType(Integer code, String name) {
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

  public static Optional<AccountType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(AccountType.class, code));
  }

}
