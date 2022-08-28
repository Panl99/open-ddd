package com.only4play.system.template.extension.cola;

import com.alibaba.cola.extension.Extension;
import lombok.extern.slf4j.Slf4j;

@Extension(bizId = "v1")
@Slf4j
public class HelloV1ServiceExtPt implements HelloServiceExtPt{

  @Override
  public void say() {
    log.info("say v1");
  }

  @Override
  public String getName() {
    return "v1";
  }
}
