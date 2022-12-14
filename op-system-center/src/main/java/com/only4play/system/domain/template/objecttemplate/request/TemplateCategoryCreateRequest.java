// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.template.objecttemplate.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;

@Schema
public class TemplateCategoryCreateRequest implements Request {
  @Schema(
      title = "分类名称"
  )
  private String name;

  @Schema(
      title = "分类编码"
  )
  private String code;

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
}
