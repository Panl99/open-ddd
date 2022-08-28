package com.only4play.system.infrastructure.constants;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum InvoiceErrorCode implements BaseEnum<InvoiceErrorCode> {

  ENTERPRISE_NOT_FIND(1201000, "企业主体未配置"),
  TAX_RATE_NOT_CONFIG(1201001,"税率未配置"),
  INVOICE_NOT_ALLOW(1201002,"发票状态不允许开票"),
  TAX_NO_EMPTY(1201003,"纳税人识别号不能为空"),
  CUSTOMER_NAME_ILLEGAL(1201004,"名称非法"),
  ADDRESS_ILLEGAL(1201005,"地址非法"),
  PHONE_ILLEGAL(1201006,"手机号非法"),
  OPEN_BANK_ILLEGAL(1201007,"开户银行非法"),
  BANK_ACCOUNT_ILLEGAL(1201008,"账号非法"),
  TAX_NO_ILLEGAL(1201009,"纳税人识别号非法"),
  SPLIT_RESULT_EMPTY(1201010,"拆票结果为空")
  ;

  InvoiceErrorCode(Integer code, String name) {
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

  public static Optional<InvoiceErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InvoiceErrorCode.class, code));
  }

}