package com.only4play.system.domain.permission.role;

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
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.permission.role.vo")
@GenCreator(pkgName = "com.only4play.system.domain.permission.role.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.permission.role.updater")
@GenRepository(pkgName = "com.only4play.system.domain.permission.role.repository")
@GenService(pkgName = "com.only4play.system.domain.permission.role.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.permission.role.service")
@GenQuery(pkgName = "com.only4play.system.domain.permission.role.query")
@GenMapper(pkgName = "com.only4play.system.domain.permission.role.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.permission.role.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.permission.role.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.permission.role.request")
@GenResponse(pkgName = "com.only4play.system.domain.permission.role.response")
@Entity
@Table(name = "role")
@Data
public class Role extends BaseJpaAggregate {

  @FieldDesc(name = "角色编码")
  private String role;

  @FieldDesc(name = "角色名称")
  @QueryItem
  private String name;

  @QueryItem
  @FieldDesc(name = "平台Id")
  private Long platformId;

  @FieldDesc(name = "备注")
  private String remark;

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