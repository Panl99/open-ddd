package com.only4play.system.template.extension;

import com.only4play.extension.executor.Extension;
import lombok.extern.slf4j.Slf4j;

@Extension(bizId = "remote")
@Slf4j
public class StudentServiceRemoteImpl implements IStudentService{

  @Override
  public String getName() {
    log.info("remote : 1111");
    return "remote : 1111";
  }

  @Override
  public String getGrade() {
    log.info("remote: 3222");
    return "remote: 3222";
  }
}
