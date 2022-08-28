package com.only4play.order.commons.pay;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * @author gim 2021/12/2 8:27 下午
 */
public enum PayGroup implements BaseEnum<PayGroup> {

  THIRD_PAY(1, "三方支付"),
  PLATFORM_PAY(2,"平台支付"),
  VIRTUAL_PROPERTY(3,"虚拟资产"),
  BANK(4,"银行卡支付"),
  COUPON(4,"优惠劵")
  ;

  PayGroup(Integer code, String name) {
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

  public static Optional<PayGroup> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(PayGroup.class, code));
  }

}
