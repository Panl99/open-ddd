package com.only4play.system.domain.asset.asset.events;

import com.only4play.system.domain.asset.asset.Asset;
import com.only4play.system.domain.asset.asset.domainservice.model.AssetBizInfo;
import com.only4play.system.domain.asset.assetlifecycle.creator.AssetLifecycleCreator;
import com.only4play.system.domain.asset.assetlifecycle.service.IAssetLifecycleService;
import com.only4play.system.domain.asset.assetrecord.InOutType;
import com.only4play.system.domain.asset.assetrecord.creator.AssetInOutRecordCreator;
import com.only4play.system.domain.asset.assetrecord.service.IAssetInOutRecordService;
import com.only4play.system.domain.asset.warehouse.service.IWarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class AssetEventProcessor {

  private final IAssetLifecycleService assetLifecycleService;

  private final IWarehouseService warehouseService;

  private final IAssetInOutRecordService assetInOutRecordService;

  @EventListener
  public void handleAssetInForLifecycle(AssetEvents.AssetInEvent inEvent) {
    AssetBizInfo bizInfo = inEvent.getBizInfo();
    Asset asset = inEvent.getAsset();
    /**
     * 艺术性的处理采用批号的方式进行批量插入操作，避免每次事件都插入一条记录，这样有性能问题
     */
    List<AssetLifecycleCreator> assetLifecycleCreators = bizInfo.getUniqueCodes().stream()
        .map(code -> {
          AssetLifecycleCreator creator = new AssetLifecycleCreator();
          creator.setAssetsId(asset.getId());
          creator.setHouseId(asset.getHouseId());
          creator.setName(asset.getName());
          //不用关注findById 那是仓库服务应该考虑的事，最少知道原则，那个优化可以加缓存
          creator.setHouseName(warehouseService.findById(asset.getHouseId()).getName());
          creator.setInOutBizType(bizInfo.getInOutBizType());
          creator.setUniqueCode(code);
          creator.setRemark("入库");
          creator.setBatchNo(bizInfo.getBatchNo());
          creator.setGenBatchNo(bizInfo.getGenBatchNo());
          creator.setInOutType(InOutType.IN);
          creator.setSkuId(asset.getSkuId());
          creator.setOperateUser(bizInfo.getOperateUser());
          return creator;
        }).collect(Collectors.toList());
    assetLifecycleService.batchCreateLifecycle(bizInfo.getGenBatchNo(), assetLifecycleCreators);
  }

  @EventListener
  public void handleAssetOutForLifecycle(AssetEvents.AssetOutEvent outEvent) {
    AssetBizInfo bizInfo = outEvent.getBizInfo();
    Asset asset = outEvent.getAsset();
    /**
     * 艺术性的处理采用批号的方式进行批量插入操作，避免每次事件都插入一条记录，这样有性能问题
     */
    List<AssetLifecycleCreator> assetLifecycleCreators = bizInfo.getUniqueCodes().stream()
        .map(code -> {
          AssetLifecycleCreator creator = new AssetLifecycleCreator();
          creator.setAssetsId(asset.getId());
          creator.setHouseId(asset.getHouseId());
          creator.setName(asset.getName());
          //不用关注findById 那是仓库服务应该考虑的事，最少知道原则，那个优化可以加缓存
          creator.setHouseName(warehouseService.findById(asset.getHouseId()).getName());
          creator.setInOutBizType(bizInfo.getInOutBizType());
          creator.setUniqueCode(code);
          creator.setRemark("出库");
          creator.setBatchNo(bizInfo.getBatchNo());
          creator.setSkuId(asset.getSkuId());
          creator.setGenBatchNo(bizInfo.getGenBatchNo());
          creator.setInOutType(InOutType.OUT);
          creator.setOperateUser(bizInfo.getOperateUser());
          return creator;
        }).collect(Collectors.toList());
    assetLifecycleService.batchCreateLifecycle(bizInfo.getGenBatchNo(), assetLifecycleCreators);
  }

  /**
   * 保存出库记录
   *
   * @param outEvent
   */
  @EventListener
  public void handleAssetOutForRecord(AssetEvents.AssetOutEvent outEvent) {
    AssetBizInfo bizInfo = outEvent.getBizInfo();
    AssetInOutRecordCreator creator = new AssetInOutRecordCreator();
    creator.setInOutBizType(bizInfo.getInOutBizType());
    creator.setInOutType(InOutType.OUT);
    creator.setBatchNo(bizInfo.getBatchNo());
    creator.setGenBatchNo(bizInfo.getGenBatchNo());
    creator.setOperateUser(bizInfo.getOperateUser());
    creator.setTotalCount(bizInfo.getUniqueCodes().size());
    assetInOutRecordService.createAssetInOutRecord(bizInfo.getUniqueCodes(), creator);

  }

  /**
   * 保存入库记录
   * @param inEvent
   */
  @EventListener
  public void handleAssetInForRecord(AssetEvents.AssetInEvent inEvent) {
    AssetBizInfo bizInfo = inEvent.getBizInfo();
    AssetInOutRecordCreator creator = new AssetInOutRecordCreator();
    creator.setInOutBizType(bizInfo.getInOutBizType());
    creator.setInOutType(InOutType.IN);
    creator.setBatchNo(bizInfo.getBatchNo());
    creator.setGenBatchNo(bizInfo.getGenBatchNo());
    creator.setOperateUser(bizInfo.getOperateUser());
    creator.setTotalCount(bizInfo.getUniqueCodes().size());
    assetInOutRecordService.createAssetInOutRecord(bizInfo.getUniqueCodes(), creator);

  }

}
