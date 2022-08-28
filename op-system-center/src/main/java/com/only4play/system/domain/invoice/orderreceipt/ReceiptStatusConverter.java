package com.only4play.system.domain.invoice.orderreceipt;

import javax.persistence.AttributeConverter;

public class ReceiptStatusConverter implements AttributeConverter<ReceiptStatus,Integer> {

  @Override
  public Integer convertToDatabaseColumn(ReceiptStatus orderReceiptStatus) {
    return orderReceiptStatus.getCode();
  }

  @Override
  public ReceiptStatus convertToEntityAttribute(Integer code) {
    return ReceiptStatus.of(code).orElse(null);
  }
}
