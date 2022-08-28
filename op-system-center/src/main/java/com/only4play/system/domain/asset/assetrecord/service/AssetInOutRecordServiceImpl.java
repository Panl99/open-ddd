// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.asset.assetrecord.service;

import cn.hutool.core.collection.IterUtil;
import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.asset.assetrecord.AssetInOutRecord;
import com.only4play.system.domain.asset.assetrecord.AssetRecordDetail;
import com.only4play.system.domain.asset.assetrecord.QAssetInOutRecord;
import com.only4play.system.domain.asset.assetrecord.creator.AssetInOutRecordCreator;
import com.only4play.system.domain.asset.assetrecord.mapper.AssetInOutRecordMapper;
import com.only4play.system.domain.asset.assetrecord.query.AssetInOutRecordQuery;
import com.only4play.system.domain.asset.assetrecord.repository.AssetInOutRecordRepository;
import com.only4play.system.domain.asset.assetrecord.repository.AssetRecordDetailRepository;
import com.only4play.system.domain.asset.assetrecord.vo.AssetInOutRecordVO;
import com.querydsl.core.BooleanBuilder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class AssetInOutRecordServiceImpl implements IAssetInOutRecordService {

  private final AssetInOutRecordRepository assetInOutRecordRepository;

  private final AssetRecordDetailRepository assetRecordDetailRepository;

  /**
   * createImpl
   */
  @Override
  public Long createAssetInOutRecord(List<String> uniqueCodes, AssetInOutRecordCreator creator) {
    String genBatchNo = creator.getGenBatchNo();
    BooleanBuilder bb = new BooleanBuilder().and(
        QAssetInOutRecord.assetInOutRecord.genBatchNo.eq(genBatchNo));
    Iterable<AssetInOutRecord> all = assetInOutRecordRepository.findAll(bb);
    if (IterUtil.isNotEmpty(all)) {
      return 0L;
    }
    Optional<AssetInOutRecord> assetInOutRecord = EntityOperations.doCreate(
            assetInOutRecordRepository)
        .create(() -> AssetInOutRecordMapper.INSTANCE.dtoToEntity(creator))
        .update(e -> e.init())
        .execute();
    List<AssetRecordDetail> details = uniqueCodes.stream()
        .map(code -> {
          AssetRecordDetail detail = new AssetRecordDetail();
          detail.setRecordId(assetInOutRecord.get().getId());
          detail.setUniqueCode(code);
          return detail;
        }).collect(Collectors.toList());
    assetRecordDetailRepository.saveAll(details);
    return assetInOutRecord.isPresent() ? assetInOutRecord.get().getId() : 0;
  }


  /**
   * findById
   */
  @Override
  public AssetInOutRecordVO findById(Long id) {
    Optional<AssetInOutRecord> assetInOutRecord = assetInOutRecordRepository.findById(id);
    return new AssetInOutRecordVO(
        assetInOutRecord.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<AssetInOutRecordVO> findByPage(PageRequestWrapper<AssetInOutRecordQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<AssetInOutRecord> page = assetInOutRecordRepository.findAll(booleanBuilder,
        PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
            Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new AssetInOutRecordVO(entity))
        .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}
