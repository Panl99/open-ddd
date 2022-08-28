// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.message.response;

import com.only4play.common.constants.ValidStatus;
import com.only4play.common.model.AbstractJpaResponse;
import com.only4play.system.domain.message.SmsType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;

@Schema
public class SmsSendRecordResponse extends AbstractJpaResponse {
  @Schema(
      title = "phone"
  )
  private String phone;

  @Schema(
      title = "verifyCode"
  )
  private String verifyCode;

  @Schema(
      title = "smsType"
  )
  private SmsType smsType;

  @Schema(
      title = "validStatus"
  )
  private ValidStatus validStatus;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  public void setVerifyCode(String verifyCode) {
    this.verifyCode = verifyCode;
  }

  public SmsType getSmsType() {
    return smsType;
  }

  public void setSmsType(SmsType smsType) {
    this.smsType = smsType;
  }

  public ValidStatus getValidStatus() {
    return validStatus;
  }

  public void setValidStatus(ValidStatus validStatus) {
    this.validStatus = validStatus;
  }
}
