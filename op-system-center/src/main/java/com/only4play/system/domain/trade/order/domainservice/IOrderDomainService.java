package com.only4play.system.domain.trade.order.domainservice;

import com.only4play.system.domain.trade.order.domainservice.model.OrderCompleteModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCreateModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderReviseModel;

public interface IOrderDomainService {

  /**
   * 创建订单
   * @param createModel
   * @return
   */
  boolean orderCreate(OrderCreateModel createModel);

  /**
   * 订单修订
   * @param reviseModel
   * @return
   */
  boolean orderRevise(OrderReviseModel reviseModel);

  /**
   * 订单完成
   * @return
   */
  boolean orderComplete(OrderCompleteModel completeModel);

  /**
   * 订单取消
   * @return
   */
  boolean orderCancel(Long flowNo);

}
