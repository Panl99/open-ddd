package com.only4play.system.domain.user;

import javax.persistence.AttributeConverter;

public class AccountTypeConverter implements AttributeConverter<AccountType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(AccountType accountType) {
    return accountType.getCode();
  }

  @Override
  public AccountType convertToEntityAttribute(Integer code) {
    return AccountType.of(code).orElse(null);
  }
}