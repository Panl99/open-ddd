package com.only4play.system.infrastructure.converter;

import cn.hutool.core.collection.IterUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Streams;

public class ListLongConverter implements AttributeConverter<List<Long>, String> {

    @Override
    public String convertToDatabaseColumn(List<Long> longs) {
        if(IterUtil.isEmpty(longs)){
            return "";
        }
        return Joiner.on(",").join(longs);
    }

    @Override
    public List<Long> convertToEntityAttribute(String str) {
        if(StringUtils.isEmpty(str)){
            return Collections.emptyList();
        }
        return Streams.stream(Splitter.on(",").split(str))
                .map(s -> Long.valueOf(s))
                .collect(Collectors.toList());
    }
}
