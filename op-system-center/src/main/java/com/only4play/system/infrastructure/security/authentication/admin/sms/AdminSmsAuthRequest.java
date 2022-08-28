package com.only4play.system.infrastructure.security.authentication.admin.sms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class AdminSmsAuthRequest {

  private String phone;

  private String verifyCode;

}
