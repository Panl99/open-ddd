// ---Auto Generated by Only4Play ---
package com.only4play.system.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.system.domain.message.creator.SmsSendRecordCreator;
import com.only4play.system.domain.message.mapper.SmsSendRecordMapper;
import com.only4play.system.domain.message.query.SmsSendRecordQuery;
import com.only4play.system.domain.message.request.SmsSendRecordCreateRequest;
import com.only4play.system.domain.message.request.SmsSendRecordQueryRequest;
import com.only4play.system.domain.message.request.SmsSendRecordUpdateRequest;
import com.only4play.system.domain.message.response.SmsSendRecordResponse;
import com.only4play.system.domain.message.service.ISmsSendRecordService;
import com.only4play.system.domain.message.updater.SmsSendRecordUpdater;
import com.only4play.system.domain.message.vo.SmsSendRecordVO;
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
@RequestMapping("smsSendRecord/v1")
@RequiredArgsConstructor
public class SmsSendRecordController {
  private final ISmsSendRecordService smsSendRecordService;

  /**
   * createRequest
   */
  @PostMapping("createSmsSendRecord")
  public JsonObject<Long> createSmsSendRecord(@RequestBody SmsSendRecordCreateRequest request) {
    SmsSendRecordCreator creator = SmsSendRecordMapper.INSTANCE.request2Dto(request);
    return JsonObject.success(smsSendRecordService.createSmsSendRecord(creator));
  }

  /**
   * update request
   */
  @PostMapping("updateSmsSendRecord")
  public JsonObject<String> updateSmsSendRecord(@RequestBody SmsSendRecordUpdateRequest request) {
    SmsSendRecordUpdater updater = SmsSendRecordMapper.INSTANCE.request2Updater(request);
    smsSendRecordService.updateSmsSendRecord(updater);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * valid
   */
  @PostMapping("valid/{id}")
  public JsonObject<String> validSmsSendRecord(@PathVariable Long id) {
    smsSendRecordService.validSmsSendRecord(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * invalid
   */
  @PostMapping("invalid/{id}")
  public JsonObject<String> invalidSmsSendRecord(@PathVariable Long id) {
    smsSendRecordService.invalidSmsSendRecord(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  public JsonObject<SmsSendRecordResponse> findById(@PathVariable Long id) {
    SmsSendRecordVO vo = smsSendRecordService.findById(id);
    SmsSendRecordResponse response = SmsSendRecordMapper.INSTANCE.vo2CustomResponse(vo);
    return JsonObject.success(response);
  }

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  public JsonObject<PageResult<SmsSendRecordResponse>> findByPage(
      @RequestBody PageRequestWrapper<SmsSendRecordQueryRequest> request) {
    PageRequestWrapper<SmsSendRecordQuery> wrapper = new PageRequestWrapper<>();
    wrapper.setBean(SmsSendRecordMapper.INSTANCE.request2Query(request.getBean()));
    wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
    Page<SmsSendRecordVO> page = smsSendRecordService.findByPage(wrapper);
    return JsonObject.success(
            PageResult.of(
                page.getContent().stream()
                    .map(vo -> SmsSendRecordMapper.INSTANCE.vo2CustomResponse(vo))
                    .collect(Collectors.toList()),
                page.getTotalElements(),
                page.getSize(),
                page.getNumber())
        );
  }
}
