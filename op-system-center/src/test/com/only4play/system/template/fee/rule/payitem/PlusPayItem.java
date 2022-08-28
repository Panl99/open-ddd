package com.only4play.system.template.fee.rule.payitem;

import com.only4play.order.commons.pay.AbstractPayItem;
import com.only4play.order.commons.pay.PayGroup;
import com.only4play.order.commons.pay.PayType;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;


public class PlusPayItem extends AbstractPayItem {

  @Setter
  @Getter
  private String plusNo;

  @Setter
  @Getter
  private Long userId;

  public PlusPayItem(BigDecimal money, PayType payType,
      PayGroup payGroup) {
    super(money, payType, payGroup);
  }
}
