package com.only4play.security.config;

import com.google.common.collect.Lists;
import com.only4play.common.annotation.FieldDesc;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "op.security.urls")
public class SecurityCommonProperties {

  @FieldDesc(name = "不需要权限的链接地址集合")
  private List<String> unAuthUrls = Lists.newArrayList();
}
