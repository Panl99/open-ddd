package com.only4play.system.domain.permission.resource;

import javax.persistence.AttributeConverter;

public class ResourceTypeConverter implements AttributeConverter<ResourceType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(ResourceType resourceType) {
    return resourceType.getCode();
  }

  @Override
  public ResourceType convertToEntityAttribute(Integer code) {
    return ResourceType.of(code).orElse(null);
  }
}