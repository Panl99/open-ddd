package com.only4play.order.commons.pay;

import com.only4play.common.annotation.FieldDesc;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gim 2021/12/2 8:38 下午
 */
@Setter
@Getter
public class CoinPayItem extends AbstractPayItem{

  public CoinPayItem(BigDecimal money) {
    super(money, PayType.COIN, PayGroup.VIRTUAL_PROPERTY);
  }

  @FieldDesc(name = "来源")
  private String source;
  

}
