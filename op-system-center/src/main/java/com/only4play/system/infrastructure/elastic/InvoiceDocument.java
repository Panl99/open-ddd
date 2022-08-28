package com.only4play.system.infrastructure.elastic;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.InvoiceItemModel;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "invoice_index")
@Data
public class InvoiceDocument {

  private String id;

  @FieldDesc(name = "发票类型")
  private Integer invoiceType;

  @FieldDesc(name = "发票种类")
  private Integer invoiceKind;

  @FieldDesc(name = "批次号")
  private String batchNo;

  @FieldDesc(name = "第几张发票")
  private Integer indexNo;

  @FieldDesc(name = "申请渠道编码")
  private String applyChannelCode;

  @FieldDesc(name = "发票金额")
  private BigDecimal invoiceAmount;

  /**
   * 销方开票主体
   */
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

  /**
   * 操作人信息
   */
  @FieldDesc(name = "开票人")
  private String drawer;

  @FieldDesc(name = "复核人")
  private String reviewer;

  @FieldDesc(name = "收款人")
  private String payee;

  /**
   * 客户信息
   */

  @FieldDesc(name = "名称")
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

  @Field(type = FieldType.Nested)
  private List<InvoiceItemModel> itemModels;

  private Long createdAt;

  private Long updatedAt;

  private Integer validStatus;

  @FieldDesc(name = "开票时传递的属性信息")
  @Field(type = FieldType.Nested)
  private List<CodeValue> extAttrs;

}
