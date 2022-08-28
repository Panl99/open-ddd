package com.only4play.system.template.extension;

import com.only4play.extension.executor.Extension;
import lombok.extern.slf4j.Slf4j;

@Extension(bizId = "local")
@Slf4j
public class StudentServiceLocalImpl implements IStudentService{

  @Override
  public String getName() {
    log.info("local 2222");
    return "local 2222";
  }

  @Override
  public String getGrade() {
    log.info("local 4444");
    return "local 4444";
  }
}
