package com.only4play.geek.tools.func.gencode.model;

import lombok.Data;

/**
 * 模板绑定
 */
@Data
public class ArchetypeModel {

  private String archetypeArtifactId;
  private String archetypeVersion;
  private String archetypeGroupId;
  /**
   *  模板名称
   */
  private String templateName;

}