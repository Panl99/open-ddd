// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.enterpriseentity.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

@Schema
public class EnterpriseEntityUpdateRequest implements Request {
  @Schema(
      title = "税务编码"
  )
  private String taxCode;

  @Schema(
      title = "社会信用号"
  )
  private String creditNo;

  @Schema(
      title = "企业名称"
  )
  private String enterpriseName;

  @Schema(
      title = "纳税人识别号"
  )
  private String taxNo;

  @Schema(
      title = "注册地址"
  )
  private String registerAddress;

  @Schema(
      title = "注册电话"
  )
  private String registerPhone;

  @Schema(
      title = "开户银行"
  )
  private String openBank;

  @Schema(
      title = "银行账户"
  )
  private String bankAccount;

  @Schema(
      title = "增值税普通发票金额最小值"
  )
  private BigDecimal generalInvoiceMinLimit;

  @Schema(
      title = "增值税普通发票金额最大值"
  )
  private BigDecimal generalInvoiceMaxLimit;

  @Schema(
      title = "增值税专用发票金额最小值"
  )
  private BigDecimal specialInvoiceMinLimit;

  @Schema(
      title = "增值税专用发票金额最大值"
  )
  private BigDecimal specialInvoiceMaxLimit;

  private Long id;

  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public String getCreditNo() {
    return creditNo;
  }

  public void setCreditNo(String creditNo) {
    this.creditNo = creditNo;
  }

  public String getEnterpriseName() {
    return enterpriseName;
  }

  public void setEnterpriseName(String enterpriseName) {
    this.enterpriseName = enterpriseName;
  }

  public String getTaxNo() {
    return taxNo;
  }

  public void setTaxNo(String taxNo) {
    this.taxNo = taxNo;
  }

  public String getRegisterAddress() {
    return registerAddress;
  }

  public void setRegisterAddress(String registerAddress) {
    this.registerAddress = registerAddress;
  }

  public String getRegisterPhone() {
    return registerPhone;
  }

  public void setRegisterPhone(String registerPhone) {
    this.registerPhone = registerPhone;
  }

  public String getOpenBank() {
    return openBank;
  }

  public void setOpenBank(String openBank) {
    this.openBank = openBank;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public BigDecimal getGeneralInvoiceMinLimit() {
    return generalInvoiceMinLimit;
  }

  public void setGeneralInvoiceMinLimit(BigDecimal generalInvoiceMinLimit) {
    this.generalInvoiceMinLimit = generalInvoiceMinLimit;
  }

  public BigDecimal getGeneralInvoiceMaxLimit() {
    return generalInvoiceMaxLimit;
  }

  public void setGeneralInvoiceMaxLimit(BigDecimal generalInvoiceMaxLimit) {
    this.generalInvoiceMaxLimit = generalInvoiceMaxLimit;
  }

  public BigDecimal getSpecialInvoiceMinLimit() {
    return specialInvoiceMinLimit;
  }

  public void setSpecialInvoiceMinLimit(BigDecimal specialInvoiceMinLimit) {
    this.specialInvoiceMinLimit = specialInvoiceMinLimit;
  }

  public BigDecimal getSpecialInvoiceMaxLimit() {
    return specialInvoiceMaxLimit;
  }

  public void setSpecialInvoiceMaxLimit(BigDecimal specialInvoiceMaxLimit) {
    this.specialInvoiceMaxLimit = specialInvoiceMaxLimit;
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
