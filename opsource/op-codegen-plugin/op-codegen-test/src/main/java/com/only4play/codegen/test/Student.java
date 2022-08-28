package com.only4play.codegen.test;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenFeign;
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
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.codegen.test.vo")
@GenCreator(pkgName = "com.only4play.codegen.test.creator")
@GenUpdater(pkgName = "com.only4play.codegen.test.updater")
@GenRepository(pkgName = "com.only4play.codegen.test.repository")
@GenService(pkgName = "com.only4play.codegen.test.service")
@GenServiceImpl(pkgName = "com.only4play.codegen.test.service")
@GenQuery(pkgName = "com.only4play.codegen.test.query")
@GenMapper(pkgName = "com.only4play.codegen.test.mapper")
@GenController(pkgName = "com.only4play.codegen.test.controller")
@GenCreateRequest(pkgName = "com.only4play.codegen.test.api.request",sourcePath = Constants.GEN_API_SOURCE)
@GenUpdateRequest(pkgName = "com.only4play.codegen.test.api.request",sourcePath = Constants.GEN_API_SOURCE)
@GenQueryRequest(pkgName = "com.only4play.codegen.test.api.request",sourcePath = Constants.GEN_API_SOURCE)
@GenResponse(pkgName = "com.only4play.codegen.test.api.response",sourcePath = Constants.GEN_API_SOURCE)
@GenFeign(pkgName = "com.only4play.codegen.test.api.service",sourcePath = Constants.GEN_API_SOURCE,serverName ="srv")
@Entity
@Table(name = "")
@Data
public class Student extends BaseJpaAggregate {

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