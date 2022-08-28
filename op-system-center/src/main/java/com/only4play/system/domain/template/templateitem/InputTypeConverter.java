package com.only4play.system.domain.template.templateitem;

/**
 * @author gim
 */
import javax.persistence.AttributeConverter;

public class InputTypeConverter implements AttributeConverter<InputType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(InputType inputType) {
    return inputType.getCode();
  }

  @Override
  public InputType convertToEntityAttribute(Integer code) {
    return InputType.of(code).orElse(null);
  }
}
