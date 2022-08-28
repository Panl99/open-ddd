// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.trade.orderitem.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.system.domain.trade.order.domainservice.model.OrderItemModel;
import com.only4play.system.domain.trade.orderitem.OrderItem;
import com.only4play.system.domain.trade.orderitem.creator.OrderItemCreator;
import com.only4play.system.domain.trade.orderitem.query.OrderItemQuery;
import com.only4play.system.domain.trade.orderitem.request.OrderItemCreateRequest;
import com.only4play.system.domain.trade.orderitem.request.OrderItemQueryRequest;
import com.only4play.system.domain.trade.orderitem.request.OrderItemUpdateRequest;
import com.only4play.system.domain.trade.orderitem.response.OrderItemResponse;
import com.only4play.system.domain.trade.orderitem.updater.OrderItemUpdater;
import com.only4play.system.domain.trade.orderitem.vo.OrderItemVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {
        GenericEnumMapper.class,
        DateMapper.class
    }
)
public interface OrderItemMapper {
  OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

  OrderItem dtoToEntity(OrderItemCreator dto);

  OrderItemUpdater request2Updater(OrderItemUpdateRequest request);

  OrderItemCreator request2Dto(OrderItemCreateRequest request);

  OrderItemCreator model2Creator(OrderItemModel itemModel);

  OrderItem model2Entity(OrderItemModel itemModel);

  OrderItemQuery request2Query(OrderItemQueryRequest request);

  OrderItemResponse vo2Response(OrderItemVO vo);

  default OrderItemResponse vo2CustomResponse(OrderItemVO vo) {
    OrderItemResponse response = vo2Response(vo);
    return response;
  }
}