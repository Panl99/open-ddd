package com.only4play.security.base;

import lombok.Data;

@Data
public class PasswordLoginRequest {

  private String username;

  private String password;

  private boolean forceLogin;
}
