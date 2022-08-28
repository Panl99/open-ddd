package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import lombok.Data;

/**
 * 销方信息模型
 */
@Data
public class SellerModel {

  @FieldDesc(name = "名称")
  private String sellerName;

  @FieldDesc(name = "纳税人识别号")
  private String sellerTaxNo;

  @FieldDesc(name = "地址")
  private String sellerAddress;

  @FieldDesc(name = "电话")
  private String sellerPhone;

  @FieldDesc(name = "销方开户银行")
  private String sellerOpenBank;

  @FieldDesc(name = "销方账号")
  private String sellerAccount;

  @FieldDesc(name = "税务编码")
  private String taxCode;

}
