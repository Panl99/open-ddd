package com.only4play.system.domain.asset.asset.domainservice;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import com.only4play.common.exception.BusinessException;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.asset.asset.Asset;
import com.only4play.system.domain.asset.asset.QAsset;
import com.only4play.system.domain.asset.asset.creator.AssetCreator;
import com.only4play.system.domain.asset.asset.domainservice.model.AssetBizInfo;
import com.only4play.system.domain.asset.asset.domainservice.model.BatchInOutModel;
import com.only4play.system.domain.asset.asset.domainservice.model.TransferModel;
import com.only4play.system.domain.asset.asset.mapper.AssetMapper;
import com.only4play.system.domain.asset.asset.repository.AssetRepository;
import com.only4play.system.domain.asset.assetrecord.InOutBizType;
import com.only4play.system.infrastructure.constants.AssetErrorCode;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssetDomainServiceImpl implements IAssetDomainService {

    private final AssetRepository assetRepository;

    @Override
    @Transactional
    public void handleAssetIn(BatchInOutModel batchInOutModel) {
        Assert.notEmpty(batchInOutModel.getUniqueCodes());
        String genBatchNo = IdUtil.simpleUUID();
        AssetBizInfo bizInfo = AssetBizInfo
                .builder()
                .batchNo(batchInOutModel.getBatchNo())
                .genBatchNo(genBatchNo)
                .inOutBizType(batchInOutModel.getInOutBizType())
                .uniqueCodes(batchInOutModel.getUniqueCodes())
                .operateUser(batchInOutModel.getOperateUser())
                .build();
        batchInOutModel.getUniqueCodes()
                .stream()
                .forEach(code -> {
                    BooleanBuilder bb = new BooleanBuilder()
                            .and(QAsset.asset.houseId.eq(batchInOutModel.getHouseId()))
                            .and(QAsset.asset.uniqueCode.eq(code))
                            .and(QAsset.asset.skuId.eq(batchInOutModel.getSkuId()));
                    Optional<Asset> old = assetRepository.findOne(bb);
                    old.ifPresent(o -> {
                        //如果已经存在则更新入库
                        EntityOperations
                                .doUpdate(assetRepository)
                                .load(() -> old.get())
                                .update(asset -> asset.in(bizInfo))
                                .execute();
                    });
                    if (!old.isPresent()) {
                        //不存在则直接入库
                        AssetCreator creator = new AssetCreator();
                        creator.setHouseId(batchInOutModel.getHouseId());
                        creator.setName(batchInOutModel.getName());
                        creator.setSkuId(batchInOutModel.getSkuId());
                        creator.setUniqueCode(code);
                        EntityOperations
                                .doCreate(assetRepository)
                                .create(() -> AssetMapper.INSTANCE.dtoToEntity(creator))
                                .update(a -> a.in(bizInfo))
                                .execute();
                    }
                });
    }

    @Override
    @Transactional
    public void handleAssetOut(BatchInOutModel batchInOutModel) {
        Assert.notEmpty(batchInOutModel.getUniqueCodes());
        String genBatchNo = IdUtil.simpleUUID();
        AssetBizInfo bizInfo = AssetBizInfo
                .builder()
                .batchNo(batchInOutModel.getBatchNo())
                .genBatchNo(genBatchNo)
                .inOutBizType(batchInOutModel.getInOutBizType())
                .uniqueCodes(batchInOutModel.getUniqueCodes())
                .operateUser(batchInOutModel.getOperateUser())
                .build();
        batchInOutModel.getUniqueCodes()
                .stream()
                .forEach(code -> {
                    BooleanBuilder bb = new BooleanBuilder()
                            .and(QAsset.asset.houseId.eq(batchInOutModel.getHouseId()))
                            .and(QAsset.asset.uniqueCode.eq(code))
                            .and(QAsset.asset.skuId.eq(batchInOutModel.getSkuId()));
                    Optional<Asset> old = assetRepository.findOne(bb);
                    if(!old.isPresent()){
                        throw new BusinessException(AssetErrorCode.ASSET_CODE_NOT_EXIST,"资产编码:"+code);
                    }else {
                        EntityOperations
                            .doUpdate(assetRepository)
                            .load(() -> old.get())
                            .update(asset -> asset.out(bizInfo))
                            .execute();
                    }
                });
    }

    @Override
    @Transactional
    public void handleAssetTransfer(TransferModel transferModel) {
        Assert.notEmpty(transferModel.getUniqueCodes());
        String genBatchNo = IdUtil.simpleUUID();
        BatchInOutModel outModel = new BatchInOutModel();
        outModel.setBatchNo(transferModel.getBatchNo());
        outModel.setInOutBizType(InOutBizType.OUT_TRANSFER);
        outModel.setOperateUser(transferModel.getOperateUser());
        outModel.setHouseId(transferModel.getTransferOutHouseId());
        outModel.setUniqueCodes(transferModel.getUniqueCodes());
        handleAssetOut(outModel);
        log.info("处理出库完成，仓库id:{},批次号:{},自动批号:{}", transferModel.getTransferOutHouseId(),transferModel.getBatchNo(),genBatchNo);
        Optional<Asset> one = assetRepository.findOne(new BooleanBuilder().and(QAsset.asset.uniqueCode.eq(transferModel.getUniqueCodes().get(0))));
        BatchInOutModel inModel = new BatchInOutModel();
        inModel.setUniqueCodes(transferModel.getUniqueCodes());
        inModel.setName(one.get().getName());
        inModel.setInOutBizType(InOutBizType.IN_TRANSFER);
        inModel.setSkuId(transferModel.getSkuId());
        inModel.setOperateUser(transferModel.getOperateUser());
        inModel.setBatchNo(transferModel.getBatchNo());
        handleAssetIn(inModel);
        log.info("处理入库完成，仓库id:{},批次号:{},自动批号:{}", transferModel.getTransferOutHouseId(),transferModel.getBatchNo(),genBatchNo);

    }
}
