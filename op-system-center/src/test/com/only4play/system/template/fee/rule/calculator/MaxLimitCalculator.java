package com.only4play.system.template.fee.rule.calculator;

import cn.hutool.core.util.NumberUtil;
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
import com.only4play.system.template.fee.rule.payitem.MaxLimitPayItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MaxLimitCalculator extends AbstractCalculator<OrderInfo> {

  private final BigDecimal maxAmount;

  private Optional<BigDecimal> limitDeductAmount = Optional.empty();

  public MaxLimitCalculator(FeeCalculate feeCalculate,
      Unique unique, BigDecimal maxAmount) {
    super(feeCalculate, unique);
    this.maxAmount = maxAmount;
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
      OrderInfo o) {
    //如果剩余的钱比限额大，那么大于限额的钱就是抵扣的钱
    Map<FeeItemType, BigDecimal> maps = Maps.newHashMap();
    if(NumberUtil.isGreater(left.get(FeeItemType.SERVICE_FEE),maxAmount)){
      maps.put(FeeItemType.SERVICE_FEE,NumberUtil.sub(left.get(FeeItemType.SERVICE_FEE),maxAmount));
      this.limitDeductAmount = Optional.of(NumberUtil.sub(left.get(FeeItemType.SERVICE_FEE),maxAmount));
    }
    return maps;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType, List<PayItem>> map = Maps.newHashMap();
    if(limitDeductAmount.isPresent()){
      List<PayItem> list = Lists.newArrayList();
      MaxLimitPayItem maxLimitPayItem = new MaxLimitPayItem(limitDeductAmount.get(), PayType.COIN,
          PayGroup.VIRTUAL_PROPERTY);
      list.add(maxLimitPayItem);
      map.put(FeeItemType.SERVICE_FEE,list);
    }
    return map;
  }
}
