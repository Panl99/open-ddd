package com.only4play.system.domain.invoice.taxrateconfig;

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
import java.math.BigDecimal;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.taxrateconfig.response")
@Entity
@Table(name = "tax_rate_config")
@Data
public class TaxRateConfig extends BaseJpaAggregate {

  /**
   * ????????????????????????????????????????????????????????? ??????????????????????????????????????????????????????
   * ??????????????????????????????
   * ?????????????????????????????????????????????
   */
//  @FieldDesc(name = "??????id")
//  private Long enterpriseId;

  @FieldDesc(name = "??????")
  private BigDecimal taxRate;

  @FieldDesc(name = "??????????????????")
  private String taxCategoryCode;

  @FieldDesc(name = "????????????")
  private String taxCategory;

  @FieldDesc(name = "??????????????????")
  private String displayName;

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
