// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.enterpriserouter.response;

import com.only4play.common.constants.ValidStatus;
import com.only4play.common.model.AbstractJpaResponse;
import com.only4play.system.infrastructure.model.CodeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Long;
import java.lang.String;
import java.util.List;

@Schema
public class EnterpriseRouterResponse extends AbstractJpaResponse {
  @Schema(
      title = "codeValueList"
  )
  private List<CodeValue> codeValueList;

  @Schema(
      title = "enterpriseId"
  )
  private Long enterpriseId;

  @Schema(
      title = "税务编码"
  )
  private String taxCode;

  @Schema(
      title = "validStatus"
  )
  private ValidStatus validStatus;

  public List<CodeValue> getCodeValueList() {
    return codeValueList;
  }

  public void setCodeValueList(List<CodeValue> codeValueList) {
    this.codeValueList = codeValueList;
  }

  public Long getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(Long enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public ValidStatus getValidStatus() {
    return validStatus;
  }

  public void setValidStatus(ValidStatus validStatus) {
    this.validStatus = validStatus;
  }
}
