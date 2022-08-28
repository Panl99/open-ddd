package com.only4play.system.domain.message;

import javax.persistence.AttributeConverter;

public class SmsTypeConverter implements AttributeConverter<SmsType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(SmsType smsType) {
    return smsType.getCode();
  }

  @Override
  public SmsType convertToEntityAttribute(Integer code) {
    return SmsType.of(code).orElse(null);
  }
}
