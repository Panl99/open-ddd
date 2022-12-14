// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.taxrateconfig.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

@Schema
public class TaxRateConfigCreateRequest implements Request {
  @Schema(
      title = "企业id"
  )
  private Long enterpriseId;

  @Schema(
      title = "税务分类"
  )
  private String taxCategoryNo;

  @Schema(
      title = "税率"
  )
  private BigDecimal taxRate;

  public Long getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(Long enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  public String getTaxCategoryNo() {
    return taxCategoryNo;
  }

  public void setTaxCategoryNo(String taxCategoryNo) {
    this.taxCategoryNo = taxCategoryNo;
  }

  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }
}
