// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.permission.resource.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Long;
import java.lang.String;

@Schema
public class ResourceQueryRequest implements Request {
  @Schema(
      title = "资源名称"
  )
  private String name;

  @Schema(
      title = "资源编码"
  )
  private String code;

  @Schema(
      title = "平台id"
  )
  private Long platformId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Long getPlatformId() {
    return platformId;
  }

  public void setPlatformId(Long platformId) {
    this.platformId = platformId;
  }
}
