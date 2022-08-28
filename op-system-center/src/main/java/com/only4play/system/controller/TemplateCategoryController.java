// ---Auto Generated by Only4Play ---
package com.only4play.system.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.system.domain.template.objecttemplate.creator.TemplateCategoryCreator;
import com.only4play.system.domain.template.objecttemplate.mapper.TemplateCategoryMapper;
import com.only4play.system.domain.template.objecttemplate.query.TemplateCategoryQuery;
import com.only4play.system.domain.template.objecttemplate.request.TemplateCategoryCreateRequest;
import com.only4play.system.domain.template.objecttemplate.request.TemplateCategoryQueryRequest;
import com.only4play.system.domain.template.objecttemplate.request.TemplateCategoryUpdateRequest;
import com.only4play.system.domain.template.objecttemplate.response.TemplateCategoryResponse;
import com.only4play.system.domain.template.objecttemplate.service.ITemplateCategoryService;
import com.only4play.system.domain.template.objecttemplate.updater.TemplateCategoryUpdater;
import com.only4play.system.domain.template.objecttemplate.vo.TemplateCategoryVO;
import java.lang.Long;
import java.lang.String;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("templateCategory/v1")
@RequiredArgsConstructor
@Validated
public class TemplateCategoryController {
  private final ITemplateCategoryService templateCategoryService;

  /**
   * createRequest
   */
  @PostMapping("createTemplateCategory")
  public JsonObject<Long> createTemplateCategory(
      @RequestBody TemplateCategoryCreateRequest request) {
    TemplateCategoryCreator creator = TemplateCategoryMapper.INSTANCE.request2Dto(request);
    return JsonObject.success(templateCategoryService.createTemplateCategory(creator));
  }

  /**
   * update request
   */
  @PostMapping("updateTemplateCategory")
  public JsonObject<String> updateTemplateCategory(
      @Valid @RequestBody TemplateCategoryUpdateRequest request) {
    TemplateCategoryUpdater updater = TemplateCategoryMapper.INSTANCE.request2Updater(request);
    templateCategoryService.updateTemplateCategory(updater);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * valid
   */
  @PostMapping("valid/{id}")
  public JsonObject<String> validTemplateCategory(@PathVariable Long id) {
    templateCategoryService.validTemplateCategory(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * invalid
   */
  @PostMapping("invalid/{id}")
  public JsonObject<String> invalidTemplateCategory(@PathVariable Long id) {
    templateCategoryService.invalidTemplateCategory(id);
    return JsonObject.success(CodeEnum.Success.getName());
  }

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  public JsonObject<TemplateCategoryResponse> findById(@PathVariable Long id) {
    TemplateCategoryVO vo = templateCategoryService.findById(id);
    TemplateCategoryResponse response = TemplateCategoryMapper.INSTANCE.vo2CustomResponse(vo);
    return JsonObject.success(response);
  }

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  public JsonObject<PageResult<TemplateCategoryResponse>> findByPage(
      @RequestBody PageRequestWrapper<TemplateCategoryQueryRequest> request) {
    PageRequestWrapper<TemplateCategoryQuery> wrapper = new PageRequestWrapper<>();
    wrapper.setBean(TemplateCategoryMapper.INSTANCE.request2Query(request.getBean()));
    wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
    Page<TemplateCategoryVO> page = templateCategoryService.findByPage(wrapper);
    return JsonObject.success(
            PageResult.of(
                page.getContent().stream()
                    .map(vo -> TemplateCategoryMapper.INSTANCE.vo2CustomResponse(vo))
                    .collect(Collectors.toList()),
                page.getTotalElements(),
                page.getSize(),
                page.getNumber())
        );
  }
}
