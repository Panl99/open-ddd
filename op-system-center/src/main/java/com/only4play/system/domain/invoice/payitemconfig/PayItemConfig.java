package com.only4play.system.domain.invoice.payitemconfig;

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
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.annotation.TypeConverter;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import com.only4play.order.commons.pay.PayType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 支付方式开票配置
 */
@GenVo(pkgName = "com.only4play.system.domain.invoice.payitemconfig.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.payitemconfig.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.payitemconfig.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.payitemconfig.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.payitemconfig.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.payitemconfig.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.payitemconfig.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.payitemconfig.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.payitemconfig.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.payitemconfig.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.payitemconfig.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.payitemconfig.response")
@Entity
@Table(name = "pay_item_config")
@Data
public class PayItemConfig extends BaseJpaAggregate {

  @FieldDesc(name = "交易类型编码")
  private String tradeTypeCode;

  @FieldDesc(name = "支付类型")
  @Convert(converter = PayTypeConverter.class)
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  private PayType payType;

  @FieldDesc(name = "是否支持开票")
  @Convert(converter = ValidStatusConverter.class)
  @TypeConverter(toTypeFullName = "java.lang.Integer")
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