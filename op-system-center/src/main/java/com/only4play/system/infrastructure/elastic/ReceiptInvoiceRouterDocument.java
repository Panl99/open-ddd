package com.only4play.system.infrastructure.elastic;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.system.infrastructure.model.CodeValue;
import java.util.List;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 通过订单找发票的路由，通过发票批次号找到订单
 */
@Document(indexName = "order_invoice_router_index")
@Data
public class ReceiptInvoiceRouterDocument {

  private String id;

  @FieldDesc(name = "订单流水号")
  private String orderFlowNo;

  @FieldDesc(name = "注册流水号")
  private String registerFlowNo;

  @FieldDesc(name = "发票的批号")
  private String batchNo;

  @FieldDesc(name = "订单属性信息")
  @Field(type = FieldType.Nested)
  private List<CodeValue> orderAttrs;

  @FieldDesc(name = "发票属性信息")
  @Field(type = FieldType.Nested)
  private List<CodeValue> extAttrs;

}
