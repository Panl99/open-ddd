// ---Auto Generated by Only4Play ---
package com.only4play.system.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.system.domain.invoice.orderreceipt.creator.ReceiptItemCreator;
import com.only4play.system.domain.invoice.orderreceipt.mapper.ReceiptItemMapper;
import com.only4play.system.domain.invoice.orderreceipt.query.ReceiptItemQuery;
import com.only4play.system.domain.invoice.orderreceipt.request.ReceiptItemCreateRequest;
import com.only4play.system.domain.invoice.orderreceipt.request.ReceiptItemQueryRequest;
import com.only4play.system.domain.invoice.orderreceipt.request.ReceiptItemUpdateRequest;
import com.only4play.system.domain.invoice.orderreceipt.response.ReceiptItemResponse;
import com.only4play.system.domain.invoice.orderreceipt.service.IReceiptItemService;
import com.only4play.system.domain.invoice.orderreceipt.updater.ReceiptItemUpdater;
import com.only4play.system.domain.invoice.orderreceipt.vo.ReceiptItemVO;
import java.lang.Long;
import java.lang.String;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("receiptItem/v1")
@RequiredArgsConstructor
public class ReceiptItemController {
  private final IReceiptItemService receiptItemService;

  /**
   * createRequest
   */
  @PostMapping("createReceiptItem")
  public JsonObject<Long> createReceiptItem(@RequestBody ReceiptItemCreateRequest request) {
    ReceiptItemCreator creator = ReceiptItemMapper.INSTANCE.request2Dto(request);
    return JsonObject.success(receiptItemService.createReceiptItem(creator));
  }

  /**
   * update request
   */
  @PostMapping("updateReceiptItem")
  public JsonObject<String> updateReceiptItem(@RequestBody ReceiptItemUpdateRequest request) {
    ReceiptItemUpdater updater = ReceiptItemMapper.INSTANCE.request2Updater(request);
    receiptItemService.updateReceiptItem(updater);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  public JsonObject<ReceiptItemResponse> findById(@PathVariable Long id) {
    ReceiptItemVO vo = receiptItemService.findById(id);
    ReceiptItemResponse response = ReceiptItemMapper.INSTANCE.vo2CustomResponse(vo);
    return JsonObject.success(response);
  }

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  public JsonObject<PageResult<ReceiptItemResponse>> findByPage(
      @RequestBody PageRequestWrapper<ReceiptItemQueryRequest> request) {
    PageRequestWrapper<ReceiptItemQuery> wrapper = new PageRequestWrapper<>();
    wrapper.setBean(ReceiptItemMapper.INSTANCE.request2Query(request.getBean()));
    wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
    Page<ReceiptItemVO> page = receiptItemService.findByPage(wrapper);
    return JsonObject.success(
            PageResult.of(
                page.getContent().stream()
                    .map(vo -> ReceiptItemMapper.INSTANCE.vo2CustomResponse(vo))
                    .collect(Collectors.toList()),
                page.getTotalElements(),
                page.getSize(),
                page.getNumber())
        );
  }
}