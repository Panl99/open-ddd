// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.invoice.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;

@Schema
public class InvoiceCreateRequest implements Request {
  @Schema(
      title = "名称"
  )
  private String name;

  @Schema(
      title = "纳税人识别号"
  )
  private String taxNo;

  @Schema(
      title = "地址及电话"
  )
  private String addressPhone;

  @Schema(
      title = "银行及账号"
  )
  private String bankAccount;

  @Schema(
      title = "开票人"
  )
  private String drawer;

  @Schema(
      title = "复核人"
  )
  private String reviewer;

  @Schema(
      title = "收款人"
  )
  private String payee;

  @Schema(
      title = "名称"
  )
  private String customerName;

  @Schema(
      title = "纳税人识别号"
  )
  private String customerTaxNo;

  @Schema(
      title = "客户地址"
  )
  private String customerAddress;

  @Schema(
      title = "客户电话"
  )
  private String customerPhone;

  @Schema(
      title = "客户开户银行"
  )
  private String customerOpenBank;

  @Schema(
      title = "客户银行账号"
  )
  private String customerAccount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTaxNo() {
    return taxNo;
  }

  public void setTaxNo(String taxNo) {
    this.taxNo = taxNo;
  }

  public String getAddressPhone() {
    return addressPhone;
  }

  public void setAddressPhone(String addressPhone) {
    this.addressPhone = addressPhone;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public String getDrawer() {
    return drawer;
  }

  public void setDrawer(String drawer) {
    this.drawer = drawer;
  }

  public String getReviewer() {
    return reviewer;
  }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }

  public String getPayee() {
    return payee;
  }

  public void setPayee(String payee) {
    this.payee = payee;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerTaxNo() {
    return customerTaxNo;
  }

  public void setCustomerTaxNo(String customerTaxNo) {
    this.customerTaxNo = customerTaxNo;
  }

  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  public String getCustomerOpenBank() {
    return customerOpenBank;
  }

  public void setCustomerOpenBank(String customerOpenBank) {
    this.customerOpenBank = customerOpenBank;
  }

  public String getCustomerAccount() {
    return customerAccount;
  }

  public void setCustomerAccount(String customerAccount) {
    this.customerAccount = customerAccount;
  }
}
