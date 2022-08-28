package com.only4play.system.domain.template.objecttemplate;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
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

@GenVo(pkgName = "com.only4play.system.domain.template.objecttemplate.vo")
@GenCreator(pkgName = "com.only4play.system.domain.template.objecttemplate.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.template.objecttemplate.updater")
@GenRepository(pkgName = "com.only4play.system.domain.template.objecttemplate.repository")
@GenService(pkgName = "com.only4play.system.domain.template.objecttemplate.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.template.objecttemplate.service")
@GenQuery(pkgName = "com.only4play.system.domain.template.objecttemplate.query")
@GenMapper(pkgName = "com.only4play.system.domain.template.objecttemplate.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.template.objecttemplate.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.template.objecttemplate.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.template.objecttemplate.request")
@GenResponse(pkgName = "com.only4play.system.domain.template.objecttemplate.response")
@Entity
@Table(name = "template_category")
@Data
public class TemplateCategory extends BaseJpaAggregate {

  @FieldDesc(name = "分类名称")
  private String name;

  /**
   * 分类编码约定规律，这时业务系统好使用
   */
  @FieldDesc(name = "分类编码")
  private String code;

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
