// ---Auto Generated by Only4Play ---
package com.only4play.system.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.system.domain.trade.reviserecord.creator.ReviseRecordCreator;
import com.only4play.system.domain.trade.reviserecord.mapper.ReviseRecordMapper;
import com.only4play.system.domain.trade.reviserecord.query.ReviseRecordQuery;
import com.only4play.system.domain.trade.reviserecord.request.ReviseRecordCreateRequest;
import com.only4play.system.domain.trade.reviserecord.request.ReviseRecordQueryRequest;
import com.only4play.system.domain.trade.reviserecord.request.ReviseRecordUpdateRequest;
import com.only4play.system.domain.trade.reviserecord.response.ReviseRecordResponse;
import com.only4play.system.domain.trade.reviserecord.service.IReviseRecordService;
import com.only4play.system.domain.trade.reviserecord.updater.ReviseRecordUpdater;
import com.only4play.system.domain.trade.reviserecord.vo.ReviseRecordVO;
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
@RequestMapping("reviseRecord/v1")
@RequiredArgsConstructor
public class ReviseRecordController {
  private final IReviseRecordService reviseRecordService;

  /**
   * createRequest
   */
  @PostMapping("createReviseRecord")
  public JsonObject<Long> createReviseRecord(@RequestBody ReviseRecordCreateRequest request) {
    ReviseRecordCreator creator = ReviseRecordMapper.INSTANCE.request2Dto(request);
    return JsonObject.success(reviseRecordService.createReviseRecord(creator));
  }

  /**
   * update request
   */
  @PostMapping("updateReviseRecord")
  public JsonObject<String> updateReviseRecord(@RequestBody ReviseRecordUpdateRequest request) {
    ReviseRecordUpdater updater = ReviseRecordMapper.INSTANCE.request2Updater(request);
    reviseRecordService.updateReviseRecord(updater);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * valid
   */
  @PostMapping("valid/{id}")
  public JsonObject<String> validReviseRecord(@PathVariable Long id) {
    reviseRecordService.validReviseRecord(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * invalid
   */
  @PostMapping("invalid/{id}")
  public JsonObject<String> invalidReviseRecord(@PathVariable Long id) {
    reviseRecordService.invalidReviseRecord(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  public JsonObject<ReviseRecordResponse> findById(@PathVariable Long id) {
    ReviseRecordVO vo = reviseRecordService.findById(id);
    ReviseRecordResponse response = ReviseRecordMapper.INSTANCE.vo2CustomResponse(vo);
    return JsonObject.success(response);
  }

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  public JsonObject<PageResult<ReviseRecordResponse>> findByPage(
      @RequestBody PageRequestWrapper<ReviseRecordQueryRequest> request) {
    PageRequestWrapper<ReviseRecordQuery> wrapper = new PageRequestWrapper<>();
    wrapper.setBean(ReviseRecordMapper.INSTANCE.request2Query(request.getBean()));
    wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
    Page<ReviseRecordVO> page = reviseRecordService.findByPage(wrapper);
    return JsonObject.success(
            PageResult.of(
                page.getContent().stream()
                    .map(vo -> ReviseRecordMapper.INSTANCE.vo2CustomResponse(vo))
                    .collect(Collectors.toList()),
                page.getTotalElements(),
                page.getSize(),
                page.getNumber())
        );
  }
}