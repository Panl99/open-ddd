package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.order.commons.pay.PayItem;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class OrderRegisterResultModel {

  /**
   * 凭据项信息
   */
  private List<ReceiptItemModel> items;

  /**
   * 有效金额
   */
  private List<PayItem> validList;

  /**
   * 无效金额
   */
  private List<PayItem> invalidList;

  /**
   * 税务编码
   */
  private String taxCode;


  @Data
  public static class ReceiptItemModel {
    @FieldDesc(name = "商品名称")
    private String skuName;

    @FieldDesc(name = "skuId")
    private Long skuId;

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

    @FieldDesc(name = "数量")
    private Integer count;

    @FieldDesc(name = "单位")
    private String itemUnit;
  }

}
