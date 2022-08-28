// ---Auto Generated by Only4Play ---
package com.only4play.system.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.system.domain.invoice.taxrateconfig.creator.TaxRateConfigCreator;
import com.only4play.system.domain.invoice.taxrateconfig.mapper.TaxRateConfigMapper;
import com.only4play.system.domain.invoice.taxrateconfig.query.TaxRateConfigQuery;
import com.only4play.system.domain.invoice.taxrateconfig.request.TaxRateConfigCreateRequest;
import com.only4play.system.domain.invoice.taxrateconfig.request.TaxRateConfigQueryRequest;
import com.only4play.system.domain.invoice.taxrateconfig.request.TaxRateConfigUpdateRequest;
import com.only4play.system.domain.invoice.taxrateconfig.response.TaxRateConfigResponse;
import com.only4play.system.domain.invoice.taxrateconfig.service.ITaxRateConfigService;
import com.only4play.system.domain.invoice.taxrateconfig.updater.TaxRateConfigUpdater;
import com.only4play.system.domain.invoice.taxrateconfig.vo.TaxRateConfigVO;
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
@RequestMapping("taxRateConfig/v1")
@RequiredArgsConstructor
public class TaxRateConfigController {
  private final ITaxRateConfigService taxRateConfigService;

  /**
   * createRequest
   */
  @PostMapping("createTaxRateConfig")
  public JsonObject<Long> createTaxRateConfig(@RequestBody TaxRateConfigCreateRequest request) {
    TaxRateConfigCreator creator = TaxRateConfigMapper.INSTANCE.request2Dto(request);
    return JsonObject.success(taxRateConfigService.createTaxRateConfig(creator));
  }

  /**
   * update request
   */
  @PostMapping("updateTaxRateConfig")
  public JsonObject<String> updateTaxRateConfig(@RequestBody TaxRateConfigUpdateRequest request) {
    TaxRateConfigUpdater updater = TaxRateConfigMapper.INSTANCE.request2Updater(request);
    taxRateConfigService.updateTaxRateConfig(updater);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * valid
   */
  @PostMapping("valid/{id}")
  public JsonObject<String> validTaxRateConfig(@PathVariable Long id) {
    taxRateConfigService.validTaxRateConfig(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * invalid
   */
  @PostMapping("invalid/{id}")
  public JsonObject<String> invalidTaxRateConfig(@PathVariable Long id) {
    taxRateConfigService.invalidTaxRateConfig(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  public JsonObject<TaxRateConfigResponse> findById(@PathVariable Long id) {
    TaxRateConfigVO vo = taxRateConfigService.findById(id);
    TaxRateConfigResponse response = TaxRateConfigMapper.INSTANCE.vo2CustomResponse(vo);
    return JsonObject.success(response);
  }

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  public JsonObject<PageResult<TaxRateConfigResponse>> findByPage(
      @RequestBody PageRequestWrapper<TaxRateConfigQueryRequest> request) {
    PageRequestWrapper<TaxRateConfigQuery> wrapper = new PageRequestWrapper<>();
    wrapper.setBean(TaxRateConfigMapper.INSTANCE.request2Query(request.getBean()));
    wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
    Page<TaxRateConfigVO> page = taxRateConfigService.findByPage(wrapper);
    return JsonObject.success(
            PageResult.of(
                page.getContent().stream()
                    .map(vo -> TaxRateConfigMapper.INSTANCE.vo2CustomResponse(vo))
                    .collect(Collectors.toList()),
                page.getTotalElements(),
                page.getSize(),
                page.getNumber())
        );
  }
}