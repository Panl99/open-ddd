package com.only4play.system.template.extension;

import com.only4play.common.constants.BaseEnum;
import com.only4play.extension.executor.BizScene;
import java.util.Optional;

public enum StudentBiz implements BaseEnum<StudentBiz> ,BizScene{

  LOCAL(1, "local"),
  REMOTE(2,"remote")
  ;

  StudentBiz(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  private Integer code;
  private String name;

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public static Optional<StudentBiz> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(StudentBiz.class, code));
  }

  @Override
  public String getBizId() {
    return this.name;
  }
}
