package com.only4play.system.domain.trade.reviserecord;

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

@GenVo(pkgName = "com.only4play.system.domain.trade.reviserecord.vo")
@GenCreator(pkgName = "com.only4play.system.domain.trade.reviserecord.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.trade.reviserecord.updater")
@GenRepository(pkgName = "com.only4play.system.domain.trade.reviserecord.repository")
@GenService(pkgName = "com.only4play.system.domain.trade.reviserecord.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.trade.reviserecord.service")
@GenQuery(pkgName = "com.only4play.system.domain.trade.reviserecord.query")
@GenMapper(pkgName = "com.only4play.system.domain.trade.reviserecord.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.trade.reviserecord.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.trade.reviserecord.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.trade.reviserecord.request")
@GenResponse(pkgName = "com.only4play.system.domain.trade.reviserecord.response")
@Entity
@Table(name = "revise_record")
@Data
public class ReviseRecord extends BaseJpaAggregate {

  @FieldDesc(name = "?????????")
  private String operateUser;

  @QueryItem
  @FieldDesc(name = "????????????")
  private Long flowNo;

  @FieldDesc(name = "?????????")
  private String reviseBefore;

  @FieldDesc(name = "?????????")
  private String reviseAfter;

  @FieldDesc(name = "??????")
  private String diff;

  @FieldDesc(name = "??????")
  @QueryItem
  private String tableName;

  @FieldDesc(name = "????????????")
  private String reviseReason;

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
