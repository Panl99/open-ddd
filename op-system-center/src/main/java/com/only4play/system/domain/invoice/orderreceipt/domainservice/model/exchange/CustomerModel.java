package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import lombok.Data;

/**
 * 消费者信息
 */
@Data
public class CustomerModel {

  @FieldDesc(name = "消费者名称")
  private String customerName;

  @FieldDesc(name = "纳税人识别号")
  private String customerTaxNo;

  @FieldDesc(name = "客户地址")
  private String customerAddress;

  @FieldDesc(name = "客户电话")
  private String customerPhone;

  @FieldDesc(name = "客户开户银行")
  private String customerOpenBank;

  @FieldDesc(name = "客户银行账号")
  private String customerAccount;

}
