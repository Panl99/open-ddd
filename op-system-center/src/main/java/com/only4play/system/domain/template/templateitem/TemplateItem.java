package com.only4play.system.domain.template.templateitem;

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
import com.only4play.common.annotation.TypeConverter;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import com.only4play.system.infrastructure.converter.CodeValueListConverter;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.template.templateitem.vo")
@GenCreator(pkgName = "com.only4play.system.domain.template.templateitem.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.template.templateitem.updater")
@GenRepository(pkgName = "com.only4play.system.domain.template.templateitem.repository")
@GenService(pkgName = "com.only4play.system.domain.template.templateitem.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.template.templateitem.service")
@GenQuery(pkgName = "com.only4play.system.domain.template.templateitem.query")
@GenMapper(pkgName = "com.only4play.system.domain.template.templateitem.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.template.templateitem.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.template.templateitem.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.template.templateitem.request")
@GenResponse(pkgName = "com.only4play.system.domain.template.templateitem.response")
@Entity
@Table(name = "template_item")
@Data
public class TemplateItem extends BaseJpaAggregate {

  @QueryItem
  @NotEmpty(message = "???????????????????????????")
  @FieldDesc(name = "??????")
  private String name;

  @FieldDesc(name = "????????????")
  @Convert(converter = InputTypeConverter.class)
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  private InputType inputType;

  @FieldDesc(name = "?????????")
  private String placeholder;

  @FieldDesc(name = "??????")
  private String code;

  @FieldDesc(name = "?????????")
  private String createUser;

  @FieldDesc(name = "?????????")
  private BigDecimal sortNum;

  @FieldDesc(name = "??????")
  private String remark;

  @FieldDesc(name = "????????????")
  @Convert(converter = ValidStatusConverter.class)
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  private ValidStatus requireFlag;

  @Convert(converter = ValidStatusConverter.class)
  @FieldDesc(name = "??????????????????")
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  private ValidStatus auditFlag;

  @FieldDesc(name = "??????????????????")
  private String selectCode;

  @FieldDesc(name = "???????????????id")
  private Long dictId;

  @FieldDesc(name = "??????????????????")
  @Convert(converter = CodeValueListConverter.class)
  @Column(columnDefinition = "text")
  private List<CodeValue> extList;

  private Long categoryId;

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
