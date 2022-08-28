package com.only4play.geek.tools.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.only4play.geek.tools.func.gencode.holder.GenInputHolder;
import com.only4play.geek.tools.func.gencode.model.ArchetypeModel;
import com.only4play.geek.tools.func.gencode.registry.TemplateRegistry;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gim
 */
@Slf4j
public class CmdUtil {

  public static void clipboard(String content) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable tf = new StringSelection(content);
    clipboard.setContents(tf, null);
  }

  /**
   mvn archetype:generate -DgroupId=com.only4play -DartifactId=op-ordersrv -Dversion=1.0.0-SNAPSHOT -Dpackage=com.only4play.order -DappName=op-ordersrv -DarchetypeArtifactId=op-service-archetype -DarchetypeGroupId=com.only4play -DarchetypeVersion=1.0.0-SNAPSHOT
   */
  public static void mavenGenerate(GenInputHolder holder) {
    ArchetypeModel templateInfo = SpringUtil.getBean(TemplateRegistry.class)
        .getTemplateByIndex(holder.getTemplate());
    if (Objects.isNull(templateInfo)) {
      throw new RuntimeException("模板不存在");
    }
    StringBuilder sb = new StringBuilder();
    sb.append(" mvn archetype:generate ");
    sb.append("-DgroupId=").append(holder.getGroupId())
        .append(" ")
        .append("-DartifactId=").append(holder.getArtifactId())
        .append(" ")
        .append("-Dversion=1.0.0-SNAPSHOT")
        .append(" ")
        .append("-Dpackage=").append(holder.getPackageName())
        .append(" ")
        .append("-DappName=").append(holder.getAppName())
        .append(" ")
        .append("-DarchetypeArtifactId=").append(templateInfo.getArchetypeArtifactId())
        .append(" ")
        .append("-DarchetypeGroupId=").append(templateInfo.getArchetypeGroupId())
        .append(" ")
        .append("-DarchetypeVersion=").append(templateInfo.getArchetypeVersion())
        .append(" ");
    clipboard(sb.toString());
  }

}