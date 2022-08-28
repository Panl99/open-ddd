package com.only4play.system.domain.trade.order;

/**
 * @author gim
 */
import javax.persistence.AttributeConverter;

public class OrderStateConverter implements AttributeConverter<OrderState,Integer> {

  @Override
  public Integer convertToDatabaseColumn(OrderState orderState) {
    return orderState.getCode();
  }

  @Override
  public OrderState convertToEntityAttribute(Integer code) {
    return OrderState.of(code).orElse(null);
  }
}
