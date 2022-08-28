package com.only4play.system.domain.asset.warehouse;

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

/**
 * 仓库
 */

@GenVo(pkgName = "com.only4play.system.domain.asset.warehouse.vo")
@GenCreator(pkgName = "com.only4play.system.domain.asset.warehouse.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.asset.warehouse.updater")
@GenRepository(pkgName = "com.only4play.system.domain.asset.warehouse.repository")
@GenService(pkgName = "com.only4play.system.domain.asset.warehouse.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.asset.warehouse.service")
@GenQuery(pkgName = "com.only4play.system.domain.asset.warehouse.query")
@GenMapper(pkgName = "com.only4play.system.domain.asset.warehouse.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.asset.warehouse.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.asset.warehouse.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.asset.warehouse.request")
@GenResponse(pkgName = "com.only4play.system.domain.asset.warehouse.response")
@Entity
@Table(name = "warehouse")
@Data
public class Warehouse extends BaseJpaAggregate {

  @FieldDesc(name = "仓库名称")
  private String name;

  @FieldDesc(name = "仓库编码")
  private String code;

  @FieldDesc(name = "创建人")
  private String createUser;

  @FieldDesc(name = "仓库地址")
  private String address;

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
