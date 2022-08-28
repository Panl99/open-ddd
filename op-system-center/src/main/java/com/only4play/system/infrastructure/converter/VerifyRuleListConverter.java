package com.only4play.system.infrastructure.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.only4play.system.domain.template.verifyrule.rule.VerifyRule;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import javax.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

public class VerifyRuleListConverter implements AttributeConverter<List<VerifyRule>,String> {
    final static Type type = new TypeReference<List<VerifyRule>>() {}.getType();
    @Override
    public String convertToDatabaseColumn(List<VerifyRule> feeRules) {
        return JSON.toJSONString(feeRules, SerializerFeature.WriteClassName);
    }

    @Override
    public List<VerifyRule> convertToEntityAttribute(String s) {
        if(StringUtils.isEmpty(s)){
            return Collections.emptyList();
        }else{
            return JSON.parseObject(s,type);
        }
    }
}
