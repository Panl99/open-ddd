package com.only4play.system.template.fee.rule;

import com.only4play.order.commons.fee.FeeItem;
import com.only4play.order.commons.fee.FeeItemType;
import com.only4play.system.template.fee.rule.context.OrderInfo;
import java.math.BigDecimal;

public class ParkingFeeItem implements FeeItem<OrderInfo> {

  private final OrderInfo orderInfo;

  public ParkingFeeItem(OrderInfo orderInfo) {
    this.orderInfo = orderInfo;
  }

  @Override
  public BigDecimal getFeeItemOriginMoney() {
    return orderInfo.getTotalMoney();
  }

  @Override
  public FeeItemType getFeeItemType() {
    return FeeItemType.SERVICE_FEE;
  }

  @Override
  public OrderInfo getOrderInfo() {
    return orderInfo;
  }
}
