package com.only4play.geek.tools.func.gencode.properties;

import com.only4play.geek.tools.func.gencode.model.ArchetypeModel;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "template")
@Data
public class TemplateProperties {

  private List<ArchetypeModel> list;

}
