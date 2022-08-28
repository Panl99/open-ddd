// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.orderreceipt.service;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.jpa.support.EntityOperations;
import com.only4play.system.domain.invoice.orderreceipt.ReceiptItem;
import com.only4play.system.domain.invoice.orderreceipt.creator.ReceiptItemCreator;
import com.only4play.system.domain.invoice.orderreceipt.mapper.ReceiptItemMapper;
import com.only4play.system.domain.invoice.orderreceipt.query.ReceiptItemQuery;
import com.only4play.system.domain.invoice.orderreceipt.repository.ReceiptItemRepository;
import com.only4play.system.domain.invoice.orderreceipt.updater.ReceiptItemUpdater;
import com.only4play.system.domain.invoice.orderreceipt.vo.ReceiptItemVO;
import com.querydsl.core.BooleanBuilder;
import java.lang.Long;
import java.lang.Override;
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
public class ReceiptItemServiceImpl implements IReceiptItemService {
  private final ReceiptItemRepository receiptItemRepository;

  /**
   * createImpl
   */
  @Override
  public Long createReceiptItem(ReceiptItemCreator creator) {
    Optional<ReceiptItem> receiptItem = EntityOperations.doCreate(receiptItemRepository)
    .create(() -> ReceiptItemMapper.INSTANCE.dtoToEntity(creator))
    .update(e -> {})
    .execute();
    return receiptItem.isPresent() ? receiptItem.get().getId() : 0;
  }

  @Override
  public void batchCreateReceiptItems(List<ReceiptItemCreator> creatorList) {
    List<ReceiptItem> items = creatorList.stream()
        .map(creator -> ReceiptItemMapper.INSTANCE.dtoToEntity(creator)).collect(
            Collectors.toList());
    receiptItemRepository.saveAll(items);
  }

  /**
   * update
   */
  @Override
  public void updateReceiptItem(ReceiptItemUpdater updater) {
    EntityOperations.doUpdate(receiptItemRepository)
    .loadById(updater.getId())
    .update(e -> updater.updateReceiptItem(e))
    .execute();
  }


  /**
   * findById
   */
  @Override
  public ReceiptItemVO findById(Long id) {
    Optional<ReceiptItem> receiptItem =  receiptItemRepository.findById(id);
    return new ReceiptItemVO(receiptItem.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<ReceiptItemVO> findByPage(PageRequestWrapper<ReceiptItemQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<ReceiptItem> page = receiptItemRepository.findAll(booleanBuilder,
            PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new ReceiptItemVO(entity))
            .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}
