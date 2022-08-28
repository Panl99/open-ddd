package com.only4play.system.template.fee.rule.calculator;

import cn.hutool.extra.spring.SpringUtil;
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
import com.only4play.system.template.fee.rule.mockbean.UserService;
import com.only4play.system.template.fee.rule.payitem.FreeTimesPayItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FreeTimesCalculator extends AbstractCalculator<OrderInfo> {

  private final Integer freeTimes;

  private Optional<BigDecimal> payItem = Optional.empty();

  public FreeTimesCalculator(FeeCalculate feeCalculate,
      Unique unique, Integer freeTimes) {
    super(feeCalculate, unique);
    this.freeTimes = freeTimes;
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
      OrderInfo o) {
    BigDecimal serviceFee = left.get(FeeItemType.SERVICE_FEE);
    UserService userService = SpringUtil.getBean(UserService.class);
    Integer hasFreeTimes = userService.hasEnjoyFreeTimes(o.getUserId());
    Map<FeeItemType, BigDecimal> currentPay = Maps.newHashMap();
    if(freeTimes > hasFreeTimes){
      //如果有免费次数
      currentPay.put(FeeItemType.SERVICE_FEE,serviceFee);
      this.payItem = Optional.of(serviceFee);
    }
    return currentPay;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType, List<PayItem>> payItemMap = Maps.newHashMap();
    if(payItem.isPresent()){
      List<PayItem> list = Lists.newArrayList();
      FreeTimesPayItem freeTimesPayItem = new FreeTimesPayItem(payItem.get(), PayType.WECHAT,
          PayGroup.VIRTUAL_PROPERTY);
      list.add(freeTimesPayItem);
      payItemMap.put(FeeItemType.SERVICE_FEE,list);
    }
    return payItemMap;
  }
}
