package com.only4play.security.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {

  private Integer code;

  public CustomAuthenticationException(Integer code, String msg) {
    super(msg);
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }

}
