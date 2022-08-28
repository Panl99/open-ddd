package com.only4play.system.infrastructure.security.authentication.admin.password;

import com.only4play.security.base.BaseUsernamePasswordToken;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class AdminUsernamePasswordToken extends BaseUsernamePasswordToken {

  public AdminUsernamePasswordToken(
      Collection<? extends GrantedAuthority> authorities,
      String username, String password) {
    super(authorities, username, password);
  }
}
