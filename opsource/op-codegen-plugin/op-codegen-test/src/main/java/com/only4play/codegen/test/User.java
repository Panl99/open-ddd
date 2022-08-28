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
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.jpa.support.BaseJpaAggregate;

/**
 * @author gim 2022/1/11 10:53 下午
 */
//
@GenVo(pkgName = "com.only4play.codegen.test.vo")
@GenCreator(pkgName = "com.only4play.codegen.test.creator")
@GenUpdater(pkgName = "com.only4play.codegen.test.updater")
@GenRepository(pkgName = "com.only4play.codegen.test.repository")
@GenService(pkgName = "com.only4play.codegen.test.service")
@GenController(pkgName = "com.only4play.codegen.test.controller")
@GenQuery(pkgName = "com.only4play.codegen.test.query")
@GenUpdateRequest(pkgName = "com.only4play.codegen.test.api.request")
@GenQueryRequest(pkgName = "com.only4play.codegen.test.api.request")
@GenResponse(pkgName = "com.only4play.codegen.test.api.response")
@GenFeign(pkgName = "com.only4play.codegen.test.api.service")
public class User extends BaseJpaAggregate {

  private String username;

  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void valid() {
  }

  public void invalid() {
  }
}
