package com.only4play.system.infrastructure.elastic;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.domain.trade.order.domainservice.model.OrderItemModel;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "order_index")
@Data
public class OrderDocument {

  private String id;

  @FieldDesc(name = "订单类型")
  private Integer orderType;

  @FieldDesc(name = "订单类型文字显示")
  private String orderTypeTxt;

  private String flowNo;

  private BigDecimal totalAmount;

  private String orderStatusTxt;

  private Integer orderStatus;

  private Long accountId;

  private Integer accountType;

  private String phone;

  @Field(type = FieldType.Nested)
  private List<CodeValue> attrs;

  @Field(type = FieldType.Nested)
  private List<PayItem> payList;

  @Field(type = FieldType.Nested)
  private List<OrderItemModel> orderItems;

  private Long payTime;

  //其他用户的信息，渠道的统计信息等

}
