package com.only4play.system.domain.asset.assetrecord;

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

@GenVo(pkgName = "com.only4play.system.domain.asset.assetrecord.vo")
@GenCreator(pkgName = "com.only4play.system.domain.asset.assetrecord.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.asset.assetrecord.updater")
@GenRepository(pkgName = "com.only4play.system.domain.asset.assetrecord.repository")
@GenService(pkgName = "com.only4play.system.domain.asset.assetrecord.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.asset.assetrecord.service")
@GenQuery(pkgName = "com.only4play.system.domain.asset.assetrecord.query")
@GenMapper(pkgName = "com.only4play.system.domain.asset.assetrecord.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.asset.assetrecord.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.asset.assetrecord.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.asset.assetrecord.request")
@GenResponse(pkgName = "com.only4play.system.domain.asset.assetrecord.response")
@Entity
@Table(name = "asset_in_out_record")
@Data
public class AssetInOutRecord extends BaseJpaAggregate {

  @FieldDesc(name = "?????????????????????,???????????????")
  private String batchNo;

  @FieldDesc(name = "???????????????????????????????????????")
  private String genBatchNo;

  @FieldDesc(name = "?????????????????????")
  @Convert(converter = InOutBizTypeConverter.class)
  private InOutBizType inOutBizType;

  @FieldDesc(name = "?????????")
  private String operateUser;

  @FieldDesc(name = "????????????")
  @Convert(converter = InOutTypeConverter.class)
  private InOutType inOutType;

  @FieldDesc(name = "??????")
  private Integer totalCount;

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
