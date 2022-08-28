package com.only4play.system.domain.permission.resource;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.query.QueryItem;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import java.math.BigDecimal;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.permission.resource.vo")
@GenCreator(pkgName = "com.only4play.system.domain.permission.resource.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.permission.resource.updater")
@GenRepository(pkgName = "com.only4play.system.domain.permission.resource.repository")
@GenService(pkgName = "com.only4play.system.domain.permission.resource.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.permission.resource.service")
@GenQuery(pkgName = "com.only4play.system.domain.permission.resource.query")
@GenMapper(pkgName = "com.only4play.system.domain.permission.resource.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.permission.resource.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.permission.resource.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.permission.resource.request")
@GenResponse(pkgName = "com.only4play.system.domain.permission.resource.response")
@Entity
@Table(name = "resource")
@Data
public class Resource extends BaseJpaAggregate {

  @FieldDesc(name = "资源名称")
  @QueryItem
  @NotBlank(message = "资源名称不能为空")
  private String name;

  @FieldDesc(name = "资源链接")
  private String url;

  @FieldDesc(name = "资源编码")
  @QueryItem
  @NotBlank(message = "资源编码不能为空")
  private String code;

  @FieldDesc(name = "前端路由")
  private String router;

  @FieldDesc(name = "父节点")
  private Long pid;

  @FieldDesc(name = "排序号")
  private BigDecimal sortNum;

  @FieldDesc(name = "icon class")
  private String iconClass;

  @Convert(converter = ResourceTypeConverter.class)
  @FieldDesc(name = "资源类型")
  private ResourceType resourceType;

  @FieldDesc(name = "资源描述")
  private String resourceDesc;

  @FieldDesc(name = "平台id")
  @QueryItem
  private Long platformId;

  @Convert(converter = ValidStatusConverter.class)
  @IgnoreUpdater
  @IgnoreCreator
  private ValidStatus validStatus;

  public void init() {
    setValidStatus(ValidStatus.VALID);
  }

  public void valid(){
    setValidStatus(ValidStatus.VALID);
  }

  public void invalid(){
    setValidStatus(ValidStatus.INVALID);
  }
}
