package com.only4play.system.infrastructure.constants;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum OrderErrorCode implements BaseEnum<OrderErrorCode> {

  PAY_TOO_BIG(1101001, "支付的金额过大"),
  ORDER_NOT_WAIT_PAY(1101002,"订单不是待支付状态"),
  PAY_LIST_IS_NULL(1101003,"支付列表不能为空"),
  PAY_AMOUNT_NOT_EQUAL_WAIT_PAY(1101004,"支付金额与待支付金额不等")
  ;

  OrderErrorCode(Integer code, String name) {
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

  public static Optional<OrderErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(OrderErrorCode.class, code));
  }

}
