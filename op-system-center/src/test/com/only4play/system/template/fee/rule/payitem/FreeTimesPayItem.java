package com.only4play.system.template.fee.rule.payitem;

import com.only4play.order.commons.pay.AbstractPayItem;
import com.only4play.order.commons.pay.PayGroup;
import com.only4play.order.commons.pay.PayType;
import java.math.BigDecimal;

public class FreeTimesPayItem extends AbstractPayItem {

  public FreeTimesPayItem(BigDecimal money, PayType payType,
      PayGroup payGroup) {
    super(money, payType, payGroup);
  }
}
