package com.only4play.system.infrastructure.constants;

/**
 * 订单属性常量字典
 */
public enum CommonCode {

  CHANNEL("channel", "渠道"),
  PROVIDER("provider", "供应商"),
  COLOR("color","颜色"),
  TRADE_CODE("trade_code", "交易编码"),
  CORP_CODE("corp_code","企业编码")
  ;

  CommonCode(String code, String name) {
    this.code = code;
    this.name = name;
  }

  private String code;
  private String name;

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }


}
