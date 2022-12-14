package com.only4play.system.domain.invoice.enterpriseentity;

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

@GenVo(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.enterpriseentity.response")
@Entity
@Table(name = "enterprise_entity")
@Data
public class EnterpriseEntity extends BaseJpaAggregate {

  @FieldDesc(name = "????????????")
  private String taxCode;

  @FieldDesc(name = "???????????????")
  private String creditNo;

  @FieldDesc(name = "????????????")
  private String enterpriseName;

  @FieldDesc(name = "??????????????????")
  private String taxNo;

  @FieldDesc(name = "????????????")
  private String registerAddress;

  @FieldDesc(name = "????????????")
  private String registerPhone;

  @FieldDesc(name = "????????????")
  private String openBank;

  @FieldDesc(name = "????????????")
  private String bankAccount;

  @FieldDesc(name = "????????????????????????????????????")
  private BigDecimal generalInvoiceMinLimit;

  @FieldDesc(name = "????????????????????????????????????")
  private BigDecimal generalInvoiceMaxLimit;

  @FieldDesc(name = "???????????????????????????")
  private BigDecimal electronicInvoiceMinLimit;

  @FieldDesc(name = "???????????????????????????")
  private BigDecimal electronicInvoiceMaxLimit;

  @FieldDesc(name = "????????????????????????????????????")
  private BigDecimal specialInvoiceMinLimit;

  @FieldDesc(name = "????????????????????????????????????")
  private BigDecimal specialInvoiceMaxLimit;

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
