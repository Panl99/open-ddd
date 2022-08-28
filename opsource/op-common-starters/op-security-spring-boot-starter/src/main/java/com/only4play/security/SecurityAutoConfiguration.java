package com.only4play.security;

import com.only4play.security.auto.SecurityConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author gim
 */
@Configuration
@ConditionalOnProperty(prefix = "op.security", name = "enable", havingValue = "true")
public class SecurityAutoConfiguration {

  @Configuration
  @ComponentScan(value = {"com.only4play.security.base","com.only4play.security.config"})
  @Import(value = {SecurityConfig.class})
  public class AdminSecurityConfig{

  }
}
