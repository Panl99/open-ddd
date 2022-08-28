package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 发票项信息
 */
@Data
public class InvoiceItemModel {

  @FieldDesc(name = "商品id")
  private Long skuId;

  @FieldDesc(name = "商品名称")
  private String skuName;

  @FieldDesc(name = "税收分类编码")
  private String taxCategoryCode;

  @FieldDesc(name = "税率")
  private BigDecimal taxRate;

  @FieldDesc(name = "税收分类")
  private String taxCategory;

  @FieldDesc(name = "金额")
  private BigDecimal amount;

  @FieldDesc(name = "发票显示名称")
  private String displayName;

  @FieldDesc(name = "订单数量")
  private Integer count;

  @FieldDesc(name = "单位")
  private String itemUnit;

  @FieldDesc(name = "行号")
  private Integer lineCode;

}
