package com.only4play.system.domain.template.selectdict;

import javax.persistence.AttributeConverter;

public class DictTypeConverter implements AttributeConverter<DictType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(DictType dictType) {
    return dictType.getCode();
  }

  @Override
  public DictType convertToEntityAttribute(Integer code) {
    return DictType.of(code).orElse(null);
  }
}
