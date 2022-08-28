package com.only4play.order.commons.test.fee.calculator;

import com.only4play.order.commons.pay.AbstractPayItem;
import com.only4play.order.commons.pay.PayGroup;
import com.only4play.order.commons.pay.PayType;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gim 2021/12/6 8:47 下午
 */
@Setter
@Getter
public class ActivityPayItem extends AbstractPayItem {

  public ActivityPayItem(BigDecimal money) {
    super(money, PayType.ACTIVITY, PayGroup.COUPON);
  }

  private String activityName;
}
