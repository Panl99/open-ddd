// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.template.objecttemplate.request;

import com.only4play.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.Long;
import java.lang.String;

@Schema
public class TemplateCategoryUpdateRequest implements Request {
  @Schema(
      title = "分类名称"
  )
  private String name;

  @Schema(
      title = "分类编码"
  )
  private String code;

  private Long id;

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

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
