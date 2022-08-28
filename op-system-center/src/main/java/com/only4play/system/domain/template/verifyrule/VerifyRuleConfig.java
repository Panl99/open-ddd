package com.only4play.system.domain.template.verifyrule;

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
import com.only4play.system.domain.template.verifyrule.rule.VerifyRule;
import com.only4play.system.infrastructure.converter.VerifyRuleListConverter;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.template.verifyrule.vo")
@GenCreator(pkgName = "com.only4play.system.domain.template.verifyrule.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.template.verifyrule.updater")
@GenRepository(pkgName = "com.only4play.system.domain.template.verifyrule.repository")
@GenService(pkgName = "com.only4play.system.domain.template.verifyrule.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.template.verifyrule.service")
@GenQuery(pkgName = "com.only4play.system.domain.template.verifyrule.query")
@GenMapper(pkgName = "com.only4play.system.domain.template.verifyrule.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.template.verifyrule.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.template.verifyrule.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.template.verifyrule.request")
@GenResponse(pkgName = "com.only4play.system.domain.template.verifyrule.response")
@Entity
@Table(name = "verify_rule_config")
@Data
public class VerifyRuleConfig extends BaseJpaAggregate {

  @FieldDesc(name = "描述信息")
  private String descInfo;

  @FieldDesc(name = "规则名称")
  private String name;

  @FieldDesc(name = "模板项ID")
  private Long itemId;

  @FieldDesc(name = "校验规则列表")
  @Convert(converter = VerifyRuleListConverter.class)
  @Column(columnDefinition = "text")
  private List<VerifyRule> ruleList;

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
