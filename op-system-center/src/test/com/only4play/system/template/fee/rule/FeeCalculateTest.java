package com.only4play.system.template.fee.rule;

import com.google.common.collect.Lists;
import com.only4play.order.commons.fee.FeeCalculate;
import com.only4play.order.commons.fee.FeeItem;
import com.only4play.order.commons.fee.FeeItemType;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.template.fee.rule.context.OrderInfo;
import com.only4play.system.template.fee.rule.factory.CalculatorFactory;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FeeCalculateTest {

  @Test
  public void testFee(){

    List<FeeRule> ruleList = Lists.newArrayList();
    FreeTimesRule freeTimesRule = new FreeTimesRule(new BigDecimal(0), FeeRuleType.FREE_TIMES,3);
    FreeTimeRule freeTimeRule = new FreeTimeRule(new BigDecimal(1),FeeRuleType.FREE_TIME,1);
    PlusRule plusRule = new PlusRule(new BigDecimal("0.95"),FeeRuleType.PLUS_RULE,4);
    MaxLimitRule maxLimitRule  = new MaxLimitRule(new BigDecimal("1.4"),FeeRuleType.MAX_LIMIT,5);

    ruleList.add(freeTimesRule);
    ruleList.add(freeTimeRule);
    ruleList.add(plusRule);
    ruleList.add(maxLimitRule);



    List<FeeItem> payItemList = Lists.newArrayList();
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setCarNo("dddd");
    orderInfo.setParkTimes(3);
    orderInfo.setUserId(4L);
    orderInfo.setTotalMoney(new BigDecimal("30"));
    ParkingFeeItem parkingFeeItem = new ParkingFeeItem(orderInfo);
    payItemList.add(parkingFeeItem);

    //核心流程

    List<FeeRule> sortRules = ruleList.stream().sorted(Comparator.comparingInt(FeeRule::getOrder))
        .collect(Collectors.toList());
    FeeCalculate calculate = null;
    for (FeeRule feeRule : sortRules) {
      calculate = CalculatorFactory.getFeeCalculateByRuleType(calculate, feeRule);
    }

    Map <FeeItemType,BigDecimal> waitPay = calculate.calculateWaitPay(payItemList);

    BigDecimal waitPayMoney = waitPay.get(FeeItemType.SERVICE_FEE);
    System.out.println("待支付金额" + waitPayMoney);

    Map<FeeItemType, List< PayItem >> map = calculate.payItemList(payItemList);

    MapUtils.debugPrint(System.out,"console",map);
    List<PayItem> payList = map.get(FeeItemType.SERVICE_FEE);
    payList.stream()
        .forEach(payItem -> {
          System.out.println(payItem.getMoney());
          System.out.println(payItem.getPayType());
          System.out.println(payItem.getPayGroup());
        });
  }

}
