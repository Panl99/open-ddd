package com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.system.domain.invoice.invoice.TitleType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceStyle;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import com.only4play.system.infrastructure.model.CodeValue;
import java.util.List;
import lombok.Data;

/**
 * 开票
 */
@Data
public class ExchangeInvoiceModel {

  @FieldDesc(name = "开票方式")
  private InvoiceStyle invoiceStyle;

  @FieldDesc(name = "开票类型")
  private InvoiceType invoiceType;
  
  @FieldDesc(name = "抬头类型")
  private TitleType titleType;

  @FieldDesc(name = "批次号")
  private String batchNo;

  @FieldDesc(name = "申请渠道编码")
  private String applyChannelCode;

  /**
   * 购方信息
   */
  private CustomerModel customerModel;

  @FieldDesc(name = "是否为预览")
  private boolean preview;

  @FieldDesc(name = "凭据Id 列表")
  private List<Long> flowNos;

  @FieldDesc(name = "操作人")
  private String operateUser;

  /**
   * 这里可以存一些开票渠道，开票人，开票单位等信息
   */
  @FieldDesc(name = "开票时传递的属性信息")
  private List<CodeValue> extAttrs;

}
