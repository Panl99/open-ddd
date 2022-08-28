package com.only4play.system.template.extension.cola;

import com.alibaba.cola.extension.Extension;
import lombok.extern.slf4j.Slf4j;

@Extension(bizId = "v2")
@Slf4j
public class HelloV2ServiceExtPt implements HelloServiceExtPt{

  @Override
  public void say() {
    log.info("v2");
  }

  @Override
  public String getName() {
    return "v2";
  }
}
