package com.only4play.order.commons.pay;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * @author gim 2021/12/2 8:28 下午
 */
public enum PayType implements BaseEnum<PayType> {

  WECHAT(1, "微信支付"),
  ALIPAY(2,"支付宝"),
  COIN(3,"虚拟币"),
  ACTIVITY(4,"活动")
  ;

  PayType(Integer code, String name) {
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

  public static Optional<PayType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(PayType.class, code));
  }

}