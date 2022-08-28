package com.only4play.geek.tools;

import cn.hutool.extra.spring.EnableSpringUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableSpringUtil
public class GeekToolsApplication {

  public static void main(String[] args) {
    //-Djava.awt.headless=false
    SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(GeekToolsApplication.class);
    springApplicationBuilder.headless(false).run(args);
  }

}
