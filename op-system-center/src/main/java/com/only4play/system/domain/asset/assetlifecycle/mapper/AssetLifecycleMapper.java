// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.assetlifecycle.mapper;

import com.only4play.common.mapper.DateMapper;
import com.only4play.common.mapper.GenericEnumMapper;
import com.only4play.system.domain.asset.assetlifecycle.AssetLifecycle;
import com.only4play.system.domain.asset.assetlifecycle.creator.AssetLifecycleCreator;
import com.only4play.system.domain.asset.assetlifecycle.query.AssetLifecycleQuery;
import com.only4play.system.domain.asset.assetlifecycle.request.AssetLifecycleCreateRequest;
import com.only4play.system.domain.asset.assetlifecycle.request.AssetLifecycleQueryRequest;
import com.only4play.system.domain.asset.assetlifecycle.request.AssetLifecycleUpdateRequest;
import com.only4play.system.domain.asset.assetlifecycle.response.AssetLifecycleResponse;
import com.only4play.system.domain.asset.assetlifecycle.updater.AssetLifecycleUpdater;
import com.only4play.system.domain.asset.assetlifecycle.vo.AssetLifecycleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {
        GenericEnumMapper.class,
        DateMapper.class
    }
)
public interface AssetLifecycleMapper {
  AssetLifecycleMapper INSTANCE = Mappers.getMapper(AssetLifecycleMapper.class);

  AssetLifecycle dtoToEntity(AssetLifecycleCreator dto);

  AssetLifecycleUpdater request2Updater(AssetLifecycleUpdateRequest request);

  AssetLifecycleCreator request2Dto(AssetLifecycleCreateRequest request);

  AssetLifecycleQuery request2Query(AssetLifecycleQueryRequest request);

  AssetLifecycleResponse vo2Response(AssetLifecycleVO vo);

  default AssetLifecycleResponse vo2CustomResponse(AssetLifecycleVO vo) {
    AssetLifecycleResponse response = vo2Response(vo);
    return response;
  }
}