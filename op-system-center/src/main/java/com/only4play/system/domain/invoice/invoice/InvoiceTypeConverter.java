package com.only4play.system.domain.invoice.invoice;

import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import javax.persistence.AttributeConverter;

public class InvoiceTypeConverter implements AttributeConverter<InvoiceType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(InvoiceType invoiceType) {
    return invoiceType.getCode();
  }

  @Override
  public InvoiceType convertToEntityAttribute(Integer code) {
    return InvoiceType.of(code).orElse(null);
  }
}
