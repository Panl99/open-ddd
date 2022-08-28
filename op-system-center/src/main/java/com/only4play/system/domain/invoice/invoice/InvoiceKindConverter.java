package com.only4play.system.domain.invoice.invoice;

import javax.persistence.AttributeConverter;

public class InvoiceKindConverter implements AttributeConverter<InvoiceKind,Integer> {

  @Override
  public Integer convertToDatabaseColumn(InvoiceKind invoiceKind) {
    return invoiceKind.getCode();
  }

  @Override
  public InvoiceKind convertToEntityAttribute(Integer code) {
    return InvoiceKind.of(code).orElse(null);
  }
}
