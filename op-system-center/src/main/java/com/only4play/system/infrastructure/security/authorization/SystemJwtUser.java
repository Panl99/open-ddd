package com.only4play.system.infrastructure.security.authorization;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.security.base.BaseJwtUser;
import lombok.Data;

/**
 * 后台用户上下文
 */
@Data
public class SystemJwtUser extends BaseJwtUser {

  @FieldDesc(name = "部门id")
  private Long departmentId;

}
