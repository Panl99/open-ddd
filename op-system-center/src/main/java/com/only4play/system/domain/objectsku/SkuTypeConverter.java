package com.only4play.system.domain.objectsku;

import javax.persistence.AttributeConverter;


public class SkuTypeConverter implements AttributeConverter<SkuType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(SkuType skuType) {
    return skuType.getCode();
  }

  @Override
  public SkuType convertToEntityAttribute(Integer code) {
    return SkuType.of(code).orElse(null);
  }
}