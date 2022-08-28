package com.only4play.system.domain.invoice.invoice;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * @author gim
 */
public enum InvoiceKind implements BaseEnum<InvoiceKind> {
  /**
   * 红票，蓝票
   */
  BLUE_TICKET(0, "蓝票"),
  RED_TICKET(1,"红票")
  ;

  InvoiceKind(Integer code, String name) {
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

  public static Optional<InvoiceKind> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InvoiceKind.class, code));
  }

}
