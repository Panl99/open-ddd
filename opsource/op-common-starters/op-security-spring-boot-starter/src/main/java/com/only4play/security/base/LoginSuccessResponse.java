package com.only4play.security.base;

import lombok.Data;

@Data
public class LoginSuccessResponse {

  private String token;
  private String username;
}
