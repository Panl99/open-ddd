package com.only4play.system.domain.invoice.orderreceipt.domainservice.model;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum InvoiceType implements BaseEnum<InvoiceType> {

  GENERAL_PAPER(1, "普通纸质票"),
  GENERAL_ELECTRONIC(2,"普通电子发票"),
  SPECIAL(3,"专用发票");

  InvoiceType(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  private Integer code;
  private String name;

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public static Optional<InvoiceType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InvoiceType.class, code));
  }

}
