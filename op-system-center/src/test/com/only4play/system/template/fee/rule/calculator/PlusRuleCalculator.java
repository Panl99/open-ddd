package com.only4play.system.template.fee.rule.calculator;

import cn.hutool.core.util.NumberUtil;
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
import com.only4play.system.template.fee.rule.mockbean.UserService.UserInfo;
import com.only4play.system.template.fee.rule.payitem.PlusPayItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * plus 会员
 */
public class PlusRuleCalculator extends AbstractCalculator<OrderInfo> {

  private final BigDecimal discount;

  private UserInfo userInfo;

  private Optional<BigDecimal> payMoney = Optional.empty();

  public PlusRuleCalculator(FeeCalculate feeCalculate, Unique unique, BigDecimal discount) {
    super(feeCalculate, unique);
    this.discount = discount;
  }

  @Override
  protected Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
      OrderInfo o) {
    BigDecimal serviceFee = left.get(FeeItemType.SERVICE_FEE);
    Map<FeeItemType, BigDecimal> map = Maps.newHashMap();
    // 查询用户信息
    UserService userService = SpringUtil.getBean(UserService.class);
    UserInfo userInfo = userService.getUserInfo(o.getUserId());
    this.userInfo = userInfo;
    if(userInfo.isPlus()){
      if(NumberUtil.isGreater(serviceFee,BigDecimal.ZERO)){
        map.put(FeeItemType.SERVICE_FEE,NumberUtil.mul(discount,serviceFee));
        this.payMoney = Optional.of(NumberUtil.mul(discount,serviceFee));
      }
    }
    return map;
  }

  @Override
  protected Map<FeeItemType, List<PayItem>> payItemList() {
    Map<FeeItemType,List<PayItem>> maps = Maps.newHashMap();
    if(payMoney.isPresent()){
      List<PayItem> list = Lists.newArrayList();
      PlusPayItem plusPayItem = new PlusPayItem(payMoney.get(), PayType.COIN, PayGroup.VIRTUAL_PROPERTY);
      plusPayItem.setPlusNo(userInfo.getPlusNo());
      list.add(plusPayItem);
      maps.put(FeeItemType.SERVICE_FEE,list);
    }
    return maps;
  }
}
