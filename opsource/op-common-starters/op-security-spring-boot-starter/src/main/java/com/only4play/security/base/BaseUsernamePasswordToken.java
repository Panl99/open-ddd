package com.only4play.security.base;

import java.util.Collection;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public abstract class BaseUsernamePasswordToken extends AbstractAuthenticationToken {

  @Getter
  private String username;
  @Getter
  private String password;


  public BaseUsernamePasswordToken(Collection<? extends GrantedAuthority> authorities,
      String username,
      String password) {
    super(authorities);
    this.username = username;
    this.password = password;
  }

  @Override
  public Object getCredentials() {
    return this.password;
  }

  @Override
  public Object getPrincipal() {
    return this.username;
  }
}
