package com.only4play.system;

import cn.hutool.extra.spring.EnableSpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

/**
 * @author gim
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableElasticsearchRepositories(basePackages = "com.only4play.system.infrastructure.elastic")
@EnableSpringUtil
public class SystemCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SystemCenterApplication.class, args);
  }

}
