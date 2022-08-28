package com.only4play.system.infrastructure.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gim
 */
@ConfigurationProperties(prefix = "es")
@Component
@Data
public class EsProperties {
  private List<String> nodes;
  private String username;
  private String password;
}
