// ---Auto Generated by Only4Play ---
package com.only4play.system.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.system.domain.invoice.payitemconfig.creator.PayItemConfigCreator;
import com.only4play.system.domain.invoice.payitemconfig.mapper.PayItemConfigMapper;
import com.only4play.system.domain.invoice.payitemconfig.query.PayItemConfigQuery;
import com.only4play.system.domain.invoice.payitemconfig.request.PayItemConfigCreateRequest;
import com.only4play.system.domain.invoice.payitemconfig.request.PayItemConfigQueryRequest;
import com.only4play.system.domain.invoice.payitemconfig.request.PayItemConfigUpdateRequest;
import com.only4play.system.domain.invoice.payitemconfig.response.PayItemConfigResponse;
import com.only4play.system.domain.invoice.payitemconfig.service.IPayItemConfigService;
import com.only4play.system.domain.invoice.payitemconfig.updater.PayItemConfigUpdater;
import com.only4play.system.domain.invoice.payitemconfig.vo.PayItemConfigVO;
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
@RequestMapping("payItemConfig/v1")
@RequiredArgsConstructor
public class PayItemConfigController {
  private final IPayItemConfigService payItemConfigService;

  /**
   * createRequest
   */
  @PostMapping("createPayItemConfig")
  public JsonObject<Long> createPayItemConfig(@RequestBody PayItemConfigCreateRequest request) {
    PayItemConfigCreator creator = PayItemConfigMapper.INSTANCE.request2Dto(request);
    return JsonObject.success(payItemConfigService.createPayItemConfig(creator));
  }

  /**
   * update request
   */
  @PostMapping("updatePayItemConfig")
  public JsonObject<String> updatePayItemConfig(@RequestBody PayItemConfigUpdateRequest request) {
    PayItemConfigUpdater updater = PayItemConfigMapper.INSTANCE.request2Updater(request);
    payItemConfigService.updatePayItemConfig(updater);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * valid
   */
  @PostMapping("valid/{id}")
  public JsonObject<String> validPayItemConfig(@PathVariable Long id) {
    payItemConfigService.validPayItemConfig(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * invalid
   */
  @PostMapping("invalid/{id}")
  public JsonObject<String> invalidPayItemConfig(@PathVariable Long id) {
    payItemConfigService.invalidPayItemConfig(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  public JsonObject<PayItemConfigResponse> findById(@PathVariable Long id) {
    PayItemConfigVO vo = payItemConfigService.findById(id);
    PayItemConfigResponse response = PayItemConfigMapper.INSTANCE.vo2CustomResponse(vo);
    return JsonObject.success(response);
  }

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  public JsonObject<PageResult<PayItemConfigResponse>> findByPage(
      @RequestBody PageRequestWrapper<PayItemConfigQueryRequest> request) {
    PageRequestWrapper<PayItemConfigQuery> wrapper = new PageRequestWrapper<>();
    wrapper.setBean(PayItemConfigMapper.INSTANCE.request2Query(request.getBean()));
    wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
    Page<PayItemConfigVO> page = payItemConfigService.findByPage(wrapper);
    return JsonObject.success(
            PageResult.of(
                page.getContent().stream()
                    .map(vo -> PayItemConfigMapper.INSTANCE.vo2CustomResponse(vo))
                    .collect(Collectors.toList()),
                page.getTotalElements(),
                page.getSize(),
                page.getNumber())
        );
  }
}
