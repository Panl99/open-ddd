package com.only4play.system.infrastructure.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.only4play.order.commons.pay.PayItem;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import javax.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author gim
 */
public class PayItemListConverter implements AttributeConverter<List<PayItem>, String> {

  final static Type type = new TypeReference<List<PayItem>>() {}.getType();
  @Override
  public String convertToDatabaseColumn(List<PayItem> feeRules) {
    return JSON.toJSONString(feeRules, SerializerFeature.WriteClassName);
  }

  @Override
  public List<PayItem> convertToEntityAttribute(String s) {
    if(StringUtils.isEmpty(s)){
      return Collections.emptyList();
    }else{
      return JSON.parseObject(s,type);
    }
  }
}
