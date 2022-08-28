package com.only4play.system.domain.invoice.orderreceipt.domainservice.model;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum InvoiceStyle implements BaseEnum<InvoiceStyle> {

  CATEGORY(1, "按类别"),
  GOODS(2,"按商品")
  ;

  InvoiceStyle(Integer code, String name) {
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

  public static Optional<InvoiceStyle> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InvoiceStyle.class, code));
  }

}