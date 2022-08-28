package com.only4play.security.config;

import com.only4play.security.base.extension.DummyUserContextAware;
import com.only4play.security.base.extension.UserContextAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

  @ConditionalOnMissingBean
  @Bean
  public UserContextAware dummyUserContext(){
    return new DummyUserContextAware();
  }

}
