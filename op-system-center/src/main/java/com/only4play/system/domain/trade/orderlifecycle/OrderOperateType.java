package com.only4play.system.domain.trade.orderlifecycle;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * @author gim
 */
public enum OrderOperateType implements BaseEnum<OrderOperateType> {

  AUTH_SUCCESS(1,"鉴权成功"),
  ORDER_CREATE(2, "订单创建"),
  PAY_SUCCESS(3,"支付成功"),
  REVISE(4,"修订完成"),
  AUTH_START(5,"鉴权请求开始"),
  AUTH_FAIL(6,"鉴权失败"),
  START_SUCCESS(7,"启动成功"),
  START_FAIL(8,"启动失败")
  ;

  OrderOperateType(Integer code, String name) {
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

  public static Optional<OrderOperateType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(OrderOperateType.class, code));
  }

}
