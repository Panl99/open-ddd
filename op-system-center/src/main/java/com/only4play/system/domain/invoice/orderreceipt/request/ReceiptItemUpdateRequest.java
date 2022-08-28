// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.orderreceipt.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

@Schema
public class ReceiptItemUpdateRequest implements Request {
  @Schema(
      title = "凭据id"
  )
  private Long receiptId;

  @Schema(
      title = "商品名称"
  )
  private String skuName;

  @Schema(
      title = "skuId"
  )
  private String skuId;

  @Schema(
      title = "税收分类编码"
  )
  private String taxCategoryCode;

  @Schema(
      title = "税率"
  )
  private BigDecimal taxRate;

  @Schema(
      title = "税收分类"
  )
  private String taxCategory;

  @Schema(
      title = "金额"
  )
  private BigDecimal amount;

  @Schema(
      title = "发票显示名称"
  )
  private String displayName;

  @Schema(
      title = "数量"
  )
  private Integer count;

  @Schema(
      title = "单位"
  )
  private String itemUnit;

  private Long id;

  public Long getReceiptId() {
    return receiptId;
  }

  public void setReceiptId(Long receiptId) {
    this.receiptId = receiptId;
  }

  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }

  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }

  public String getTaxCategoryCode() {
    return taxCategoryCode;
  }

  public void setTaxCategoryCode(String taxCategoryCode) {
    this.taxCategoryCode = taxCategoryCode;
  }

  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  public String getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getItemUnit() {
    return itemUnit;
  }

  public void setItemUnit(String itemUnit) {
    this.itemUnit = itemUnit;
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
