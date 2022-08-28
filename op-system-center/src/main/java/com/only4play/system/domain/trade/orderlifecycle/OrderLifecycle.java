package com.only4play.system.domain.trade.orderlifecycle;

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
import com.only4play.common.annotation.TypeConverter;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.trade.orderlifecycle.vo")
@GenCreator(pkgName = "com.only4play.system.domain.trade.orderlifecycle.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.trade.orderlifecycle.updater")
@GenRepository(pkgName = "com.only4play.system.domain.trade.orderlifecycle.repository")
@GenService(pkgName = "com.only4play.system.domain.trade.orderlifecycle.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.trade.orderlifecycle.service")
@GenQuery(pkgName = "com.only4play.system.domain.trade.orderlifecycle.query")
@GenMapper(pkgName = "com.only4play.system.domain.trade.orderlifecycle.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.trade.orderlifecycle.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.trade.orderlifecycle.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.trade.orderlifecycle.request")
@GenResponse(pkgName = "com.only4play.system.domain.trade.orderlifecycle.response")
@Entity
@Table(name = "order_lifecycle")
@Data
public class OrderLifecycle extends BaseJpaAggregate {

  private Long flowNo;

  @FieldDesc(name = "操作类型")
  @Convert(converter = OrderOperateTypeConverter.class)
  @TypeConverter(toTypeFullName = "java.lang.Integer")
  private OrderOperateType operateType;

  private String remark;

  private String operateUser;

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
