package com.only4play.system.infrastructure.security.authentication.admin.sms;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class AdminSmsToken extends AbstractAuthenticationToken {

  private String phone;

  public String getPhone() {
    return phone;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  private String verifyCode;

  public AdminSmsToken(String phone,String verifyCode,
      Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.phone = phone;
    this.verifyCode = verifyCode;
  }

  @Override
  public Object getCredentials() {
    return this.verifyCode;
  }

  @Override
  public Object getPrincipal() {
    return this.phone;
  }
}
