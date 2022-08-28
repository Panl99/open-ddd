package com.only4play.order.commons.test.fee;

import com.google.common.collect.Lists;
import com.only4play.order.commons.fee.FeeCalculate;
import com.only4play.order.commons.fee.FeeItem;
import com.only4play.order.commons.fee.FeeItemType;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.order.commons.test.fee.calculator.ActivityCalculator;
import com.only4play.order.commons.test.fee.calculator.CouponCalculator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author gim 2021/12/6 9:05 下午
 */
public class CalculateTest {

  public static void main(String[] args) {
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setTradeFlowNo("T0323423432");
    List<FeeItem> list = Lists.newArrayList();
    list.add(new ServiceFeeItem(orderInfo, FeeItemType.SERVICE_FEE, new BigDecimal(20)));
    FeeCalculate feeCalculate = new ActivityCalculator(new CouponCalculator(null));
    Map<FeeItemType, BigDecimal> leftPay = feeCalculate.calculateWaitPay(list);
    leftPay.forEach((k,v) -> {
      System.out.println("待支付项" + k.getName() + v.toPlainString() + "元");
    });
    Map<FeeItemType, List<PayItem>> payItemList = feeCalculate.payItemList(list);

    payItemList.forEach((k,v) -> {
      StringBuffer sb = new StringBuffer();
      v.stream().forEach(p -> {
        sb.append("支付类型:" + p.getPayType().getName());
        sb.append("支付金额:" + p.getMoney() + "元");
        sb.append(" ! ");
      });
      System.out.println("已经支付项" + k.getName() + sb);
    });
  }

}
