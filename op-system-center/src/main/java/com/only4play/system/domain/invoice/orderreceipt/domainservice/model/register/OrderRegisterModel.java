package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * 订单转化为
 */
@Data
public class OrderRegisterModel {

  @FieldDesc(
      name = "交易类型编码"
  )
  private String tradeTypeCode;

  @FieldDesc(
      name = "业务系统编码"
  )
  private String bizSystemCode;

  @FieldDesc(
      name = "订单流水号"
  )
  private String orderFlowNo;

  @FieldDesc(
      name = "订单信息"
  )
  private List<CodeValue> orderAttrs;

  @FieldDesc(
      name = "支付项明细"
  )
  private List<PayItem> payItemList;

  @FieldDesc(
      name = "用户id"
  )
  private String accountId;

  @FieldDesc(
      name = "用户类型"
  )
  private Integer accountType;

  @FieldDesc(name = "订单项")
  private List<OrderRegisterItem> orderItems;



  @Data
  public static class OrderRegisterItem{

    private Long skuId;

    private String skuName;

    private Integer count;

    private String itemUnit;

    private BigDecimal amount;

  }

}
