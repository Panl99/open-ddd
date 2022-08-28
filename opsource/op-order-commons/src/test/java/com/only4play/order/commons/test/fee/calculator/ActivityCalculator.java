package com.only4play.order.commons.test.fee.calculator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.only4play.order.commons.fee.AbstractCalculator;
import com.only4play.order.commons.fee.FeeCalculate;
import com.only4play.order.commons.fee.FeeItemType;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.order.commons.test.fee.CalculateType;
import com.only4play.order.commons.test.fee.OrderInfo;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author gim 2021/12/6 8:44 下午
 */
public class ActivityCalculator extends AbstractCalculator<OrderInfo> {

  public ActivityCalculator(FeeCalculate feeCalculate) {
    super(feeCalculate, CalculateType.ACTIVITY);
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
      OrderInfo o) {
    Map<FeeItemType, BigDecimal> map = Maps.newHashMap();
    map.put(FeeItemType.SERVICE_FEE, new BigDecimal("4"));
    System.out.println("活动抵扣了4元费用");
    return map;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType, List<PayItem>> map = Maps.newHashMap();
    List<PayItem> payItems = Lists.newArrayList();
    ActivityPayItem ap = new ActivityPayItem(new BigDecimal(4));
    ap.setActivityName("节日活动");
    payItems.add(ap);
    map.put(FeeItemType.SERVICE_FEE, payItems);
    return map;
  }
}
