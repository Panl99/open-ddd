package com.only4play.geek.tools.func.gencode.holder;

import lombok.Data;

/**
 * @author gim
 * 用户输入gencode 后存储的上下文对象
 */
@Data
public class GenInputHolder {

  private String groupId;

  private String artifactId;

  private String packageName;

  private Integer template;

  private String appName;

}
