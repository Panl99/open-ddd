package com.only4play.system.infrastructure.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.only4play.system.infrastructure.model.CodeValue;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import javax.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

public class CodeValueListConverter implements AttributeConverter<List<CodeValue>, String> {

    final static Type type = new TypeReference<List<CodeValue>>() {}.getType();

    @Override
    public String convertToDatabaseColumn(List<CodeValue> feeRules) {
        return JSON.toJSONString(feeRules);
    }

    @Override
    public List<CodeValue> convertToEntityAttribute(String s) {
        if (StringUtils.isEmpty(s)) {
            return Collections.emptyList();
        } else {
            return JSON.parseObject(s, type);
        }
    }
}
