package com.only4play.system.infrastructure.elastic;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel.ReceiptItemModel;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "order_receipt_index")
@Data
public class OrderReceiptDocument {

  private String id;

  @FieldDesc(name = "注册流水号")
  private Long registerFlowNo;

  @FieldDesc(name = "业务系统编码")
  private String bizSystemCode;

  @FieldDesc(name = "交易类型编码")
  private String tradeTypeCode;

  @FieldDesc(name = "订单属性信息")
  @Field(type = FieldType.Nested)
  private List<CodeValue> orderAttrs;

  @FieldDesc(name = "有效开票金额")
  private BigDecimal validAmount;

  @FieldDesc(name = "无效金额")
  private BigDecimal invalidAmount;

  @FieldDesc(name = "可用开票明细")
  @Field(type = FieldType.Nested)
  private List<PayItem> validList;

  @FieldDesc(name = "不可用开票明细")
  @Field(type = FieldType.Nested)
  private List<PayItem> invalidList;

  @FieldDesc(name = "凭据状态")
  private Integer receiptStatus;

  @FieldDesc(name = "是否有效")
  private Integer validStatus;

  @FieldDesc(name = "开票企业税务编码")
  private String taxCode;


  private Long createdAt;

  private Long updatedAt;

  @Field(type = FieldType.Nested)
  private List<ReceiptItemModel> receiptItemModels;

  @FieldDesc(name = "订单流水号")
  private String orderFlowNo;

}
