package com.only4play.system.domain.trade.order.domainservice.model;

import com.only4play.common.annotation.FieldDesc;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderItemModel {

  @FieldDesc(name = "真实金额")
  private BigDecimal realAmount;

  @FieldDesc(name = "计量数量")
  private Integer itemCount;

  @FieldDesc(name = "skuId")
  private Long skuId;

  @FieldDesc(name = "商品名称")
  private String goodsName;

  @FieldDesc(name = "费用描述")
  private String feeRemark;

}
