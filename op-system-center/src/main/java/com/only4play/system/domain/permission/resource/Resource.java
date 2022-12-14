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

  @FieldDesc(name = "????????????")
  @QueryItem
  @NotBlank(message = "????????????????????????")
  private String name;

  @FieldDesc(name = "????????????")
  private String url;

  @FieldDesc(name = "????????????")
  @QueryItem
  @NotBlank(message = "????????????????????????")
  private String code;

  @FieldDesc(name = "????????????")
  private String router;

  @FieldDesc(name = "?????????")
  private Long pid;

  @FieldDesc(name = "?????????")
  private BigDecimal sortNum;

  @FieldDesc(name = "icon class")
  private String iconClass;

  @Convert(converter = ResourceTypeConverter.class)
  @FieldDesc(name = "????????????")
  private ResourceType resourceType;

  @FieldDesc(name = "????????????")
  private String resourceDesc;

  @FieldDesc(name = "??????id")
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
