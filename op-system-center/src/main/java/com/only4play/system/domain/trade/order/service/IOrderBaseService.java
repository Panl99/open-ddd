// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.trade.order.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.trade.order.creator.OrderBaseCreator;
import com.only4play.system.domain.trade.order.query.OrderBaseQuery;
import com.only4play.system.domain.trade.order.updater.OrderBaseUpdater;
import com.only4play.system.domain.trade.order.vo.OrderBaseVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface IOrderBaseService {
  /**
   * create
   */
  Long createOrderBase(OrderBaseCreator creator);

  /**
   * update
   */
  void updateOrderBase(OrderBaseUpdater updater);

  /**
   * valid
   */
  void validOrderBase(Long id);

  /**
   * invalid
   */
  void invalidOrderBase(Long id);

  /**
   * findById
   */
  OrderBaseVO findById(Long id);

  /**
   * findByPage
   */
  Page<OrderBaseVO> findByPage(PageRequestWrapper<OrderBaseQuery> query);
}