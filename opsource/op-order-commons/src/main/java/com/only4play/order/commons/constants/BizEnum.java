package com.only4play.order.commons.constants;


/**
 * @author gim
 */
public enum BizEnum {
  /**
   * 业务线编码
   */
  BIZ_XXX(1, "业务编码1")
  ;

  BizEnum(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  private Integer code;
  private String name;

  public Integer getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }


}
