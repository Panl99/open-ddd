// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.template.selectdict.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.system.domain.template.selectdict.SelectDict;
import com.only4play.system.domain.template.selectdict.creator.SelectDictCreator;
import com.only4play.system.domain.template.selectdict.query.SelectDictQuery;
import com.only4play.system.domain.template.selectdict.request.SelectDictCreateRequest;
import com.only4play.system.domain.template.selectdict.request.SelectDictQueryRequest;
import com.only4play.system.domain.template.selectdict.request.SelectDictUpdateRequest;
import com.only4play.system.domain.template.selectdict.response.SelectDictResponse;
import com.only4play.system.domain.template.selectdict.updater.SelectDictUpdater;
import com.only4play.system.domain.template.selectdict.vo.SelectDictVO;
import com.only4play.system.infrastructure.converter.CustomMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {
        GenericEnumMapper.class,
        DateMapper.class,
        CustomMapper.class
    }
)
public interface SelectDictMapper {
  SelectDictMapper INSTANCE = Mappers.getMapper(SelectDictMapper.class);

  SelectDict dtoToEntity(SelectDictCreator dto);

  SelectDictUpdater request2Updater(SelectDictUpdateRequest request);

  SelectDictCreator request2Dto(SelectDictCreateRequest request);

  SelectDictQuery request2Query(SelectDictQueryRequest request);

  SelectDictResponse vo2Response(SelectDictVO vo);

  default SelectDictResponse vo2CustomResponse(SelectDictVO vo) {
    SelectDictResponse response = vo2Response(vo);
    return response;
  }
}
