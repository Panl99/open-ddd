package com.only4play.system.domain.invoice.invoice;

import javax.persistence.AttributeConverter;

public class TitleTypeConverter implements AttributeConverter<TitleType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(TitleType titleType) {
    return titleType.getCode();
  }

  @Override
  public TitleType convertToEntityAttribute(Integer code) {
    return TitleType.of(code).orElse(null);
  }
}
