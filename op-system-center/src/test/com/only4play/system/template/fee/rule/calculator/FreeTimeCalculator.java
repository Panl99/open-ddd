package com.only4play.system.template.fee.rule.calculator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.only4play.order.commons.fee.AbstractCalculator;
import com.only4play.order.commons.fee.FeeCalculate;
import com.only4play.order.commons.fee.FeeItemType;
import com.only4play.order.commons.fee.Unique;
import com.only4play.order.commons.pay.PayGroup;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.order.commons.pay.PayType;
import com.only4play.system.template.fee.rule.context.OrderInfo;
import com.only4play.system.template.fee.rule.payitem.FreeTimePayItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class FreeTimeCalculator extends AbstractCalculator<OrderInfo> {

  private final Integer freeTime;

  public FreeTimeCalculator(FeeCalculate feeCalculate,
      Unique unique, Integer freeTime) {
    super(feeCalculate, unique);
    this.freeTime = freeTime;
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
      OrderInfo o) {
    Map<FeeItemType,BigDecimal> map = Maps.newHashMap();
    map.put(FeeItemType.SERVICE_FEE,BigDecimal.ZERO);
    return map;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType,List<PayItem>> itemMaps = Maps.newHashMap();
    List<PayItem> List = Lists.newArrayList();
    FreeTimePayItem freeTimePayItem = new FreeTimePayItem(new BigDecimal(freeTime), PayType.ACTIVITY, PayGroup.VIRTUAL_PROPERTY);
    List.add(freeTimePayItem);
    itemMaps.put(FeeItemType.SERVICE_FEE,List);
    return itemMaps;
  }
}
