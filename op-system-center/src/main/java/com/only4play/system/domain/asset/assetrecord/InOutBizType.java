package com.only4play.system.domain.asset.assetrecord;


import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum InOutBizType implements BaseEnum<InOutBizType> {

  IN_FIRST(1, "初始入库"),
  OUT_TRANSFER(2,"调拨出库"),
  IN_TRANSFER(3,"调拨入库"),
  IN_BUY(4,"购买入库"),
  OUT_SALE(5,"销售出库")
  ;

  InOutBizType(Integer code, String name) {
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

  public static Optional<InOutBizType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InOutBizType.class, code));
  }

}