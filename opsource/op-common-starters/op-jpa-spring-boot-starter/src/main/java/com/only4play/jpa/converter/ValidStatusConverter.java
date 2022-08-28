package com.only4play.jpa.converter;

import com.only4play.common.constants.ValidStatus;

import javax.persistence.AttributeConverter;

public class ValidStatusConverter implements AttributeConverter<ValidStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ValidStatus validStatus) {
        return validStatus.getCode();
    }

    @Override
    public ValidStatus convertToEntityAttribute(Integer code) {
        return ValidStatus.of(code).orElse(null);
    }
}
