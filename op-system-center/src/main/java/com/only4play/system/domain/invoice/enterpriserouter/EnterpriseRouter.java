package com.only4play.system.domain.invoice.enterpriserouter;

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
import com.only4play.system.infrastructure.converter.CodeValueListConverter;
import com.only4play.system.infrastructure.model.CodeValue;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 订单到企业的路由
 */
@GenVo(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.enterpriserouter.response")
@Entity
@Table(name = "enterprise_router")
@Data
public class EnterpriseRouter extends BaseJpaAggregate {

  /**
   * tradeCode:3
   * corpCode: 5
   */
  @Convert(converter = CodeValueListConverter.class)
  private List<CodeValue> codeValueList;

  @FieldDesc(name = "企业id")
  private Long enterpriseId;

  @FieldDesc(name = "税务编码")
  private String taxCode;

  @FieldDesc(name = "排序号，数字越小，优先匹配")
  private Integer sortNum;

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
