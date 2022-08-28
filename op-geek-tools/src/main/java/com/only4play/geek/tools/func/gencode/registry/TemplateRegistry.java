package com.only4play.geek.tools.func.gencode.registry;

import com.only4play.geek.tools.func.gencode.model.ArchetypeModel;
import com.only4play.geek.tools.func.gencode.properties.TemplateProperties;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 模板注册中心
 */
@Component
@RequiredArgsConstructor
public class TemplateRegistry {

  private final TemplateProperties templateProperties;

  public ArchetypeModel getTemplateByIndex(Integer number){
    List<ArchetypeModel> list = templateProperties.getList();
    return list.get(number);
  }

  public String getTipInfo(){
    StringBuilder sb = new StringBuilder();
    sb.append("请选择模板[例 g 1]\r\n");
    List<ArchetypeModel> list = templateProperties.getList();
    for(int i=0; i< list.size(); i++){
      sb.append("[").append(i).append("]:").append(list.get(i).getTemplateName()).append("\r\n");
    }
    return sb.toString();
  }

}