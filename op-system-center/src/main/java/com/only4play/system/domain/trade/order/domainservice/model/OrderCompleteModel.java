package com.only4play.system.domain.trade.order.domainservice.model;

import com.only4play.order.commons.pay.PayItem;
import java.util.List;
import lombok.Data;

@Data
public class OrderCompleteModel {

  private Long flowNo;

  private List<PayItem> payItemList;

  private Long payTime;

}
