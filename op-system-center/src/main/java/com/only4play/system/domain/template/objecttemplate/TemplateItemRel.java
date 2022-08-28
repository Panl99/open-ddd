package com.only4play.system.domain.template.objecttemplate;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
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
@Entity
@Table(name = "template_item_rel")
@Data
public class TemplateItemRel extends BaseJpaAggregate {

  @FieldDesc(name = "模板id")
  private Long templateId;

  @FieldDesc(name = "模板项id")
  private Long itemId;

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
