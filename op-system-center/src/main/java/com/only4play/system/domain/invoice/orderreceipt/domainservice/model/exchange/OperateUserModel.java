package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import lombok.Data;

/**
 * 操作人模型
 */
@Data
public class OperateUserModel {

  @FieldDesc(name = "开票人")
  private String drawer;

  @FieldDesc(name = "复核人")
  private String reviewer;

  @FieldDesc(name = "收款人")
  private String payee;

}
