package com.only4play.system.template.fee.rule.context;

import com.only4play.common.annotation.FieldDesc;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderInfo {

  @FieldDesc(name = "车牌号")
  private String carNo;

  @FieldDesc(name = "停车时长")
  private Integer parkTimes;

  @FieldDesc(name = "userId")
  private Long userId;

  private BigDecimal totalMoney;

  //其他  购买 sku 信息


}
