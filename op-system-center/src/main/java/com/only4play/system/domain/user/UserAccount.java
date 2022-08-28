package com.only4play.system.domain.user;

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

@GenVo(pkgName = "com.only4play.system.domain.user.vo")
@GenCreator(pkgName = "com.only4play.system.domain.user.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.user.updater")
@GenRepository(pkgName = "com.only4play.system.domain.user.repository")
@GenService(pkgName = "com.only4play.system.domain.user.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.user.service")
@GenQuery(pkgName = "com.only4play.system.domain.user.query")
@GenMapper(pkgName = "com.only4play.system.domain.user.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.user.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.user.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.user.request")
@GenResponse(pkgName = "com.only4play.system.domain.user.response")
@Entity
@Table(name = "user_account")
@Data
public class UserAccount extends BaseJpaAggregate {

  @FieldDesc(name = "用户ID")
  private Long userId;

  @FieldDesc(name = "账号")
  private String accountNo;

  @FieldDesc(name = "密码")
  private String password;

  @FieldDesc(name = "账号类型")
  @Convert(converter = AccountTypeConverter.class)
  private AccountType accountType;

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
