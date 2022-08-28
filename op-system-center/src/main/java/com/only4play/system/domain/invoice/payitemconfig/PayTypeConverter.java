package com.only4play.system.domain.invoice.payitemconfig;

import com.only4play.order.commons.pay.PayType;
import javax.persistence.AttributeConverter;

public class PayTypeConverter implements AttributeConverter<PayType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(PayType payType) {
    return payType.getCode();
  }

  @Override
  public PayType convertToEntityAttribute(Integer code) {
    return PayType.of(code).orElse(null);
  }
}
