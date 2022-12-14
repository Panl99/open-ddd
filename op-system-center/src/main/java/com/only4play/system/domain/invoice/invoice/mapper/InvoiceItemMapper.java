// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.invoice.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.system.domain.invoice.invoice.InvoiceItem;
import com.only4play.system.domain.invoice.invoice.creator.InvoiceItemCreator;
import com.only4play.system.domain.invoice.invoice.query.InvoiceItemQuery;
import com.only4play.system.domain.invoice.invoice.request.InvoiceItemCreateRequest;
import com.only4play.system.domain.invoice.invoice.request.InvoiceItemQueryRequest;
import com.only4play.system.domain.invoice.invoice.request.InvoiceItemUpdateRequest;
import com.only4play.system.domain.invoice.invoice.response.InvoiceItemResponse;
import com.only4play.system.domain.invoice.invoice.updater.InvoiceItemUpdater;
import com.only4play.system.domain.invoice.invoice.vo.InvoiceItemVO;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.InvoiceItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {
        GenericEnumMapper.class,
        DateMapper.class
    }
)
public interface InvoiceItemMapper {
  InvoiceItemMapper INSTANCE = Mappers.getMapper(InvoiceItemMapper.class);

  InvoiceItem dtoToEntity(InvoiceItemCreator dto);

  InvoiceItemUpdater request2Updater(InvoiceItemUpdateRequest request);

  InvoiceItemCreator request2Dto(InvoiceItemCreateRequest request);

  InvoiceItemQuery request2Query(InvoiceItemQueryRequest request);

  InvoiceItemResponse vo2Response(InvoiceItemVO vo);
  
  InvoiceItem itemModel2InvoiceItem(InvoiceItemModel itemModel);

  default InvoiceItemResponse vo2CustomResponse(InvoiceItemVO vo) {
    InvoiceItemResponse response = vo2Response(vo);
    return response;
  }
}
