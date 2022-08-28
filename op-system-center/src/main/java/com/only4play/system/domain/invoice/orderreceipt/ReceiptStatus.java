package com.only4play.system.domain.invoice.orderreceipt;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum ReceiptStatus implements BaseEnum<ReceiptStatus> {
  
  MAKING(1, "开票中"),
  UNMAKING(2,"未开票"),
  ABANDON(3,"已作废"),
  COMPLETE(4,"已完成")
  ;

  ReceiptStatus(Integer code, String name) {
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

  public static Optional<ReceiptStatus> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(ReceiptStatus.class, code));
  }

}
