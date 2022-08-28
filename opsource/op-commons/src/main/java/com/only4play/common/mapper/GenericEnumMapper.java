package com.only4play.common.mapper;

import com.only4play.common.constants.ValidStatus;

public class GenericEnumMapper {

  public Integer asInteger(ValidStatus status) {
    return status.getCode();
  }

  public ValidStatus asValidStatus(Integer code) {
    return ValidStatus.of(code).orElse(ValidStatus.INVALID);
  }
}