package com.only4play.system.template.extension;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.only4play.extension.executor.ServiceExecutor;
import com.only4play.system.template.extension.cola.HelloServiceExtPt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ExtensionTest {

  @Autowired
  private ServiceExecutor serviceExecutor;

  @Autowired
  private ExtensionExecutor extensionExecutor;


  @Test
  public void testStudentService(){
    serviceExecutor.execute(IStudentService.class,StudentBiz.LOCAL,IStudentService::getGrade);
    serviceExecutor.execute(IStudentService.class,StudentBiz.LOCAL,IStudentService::getName);
    serviceExecutor.execute(IStudentService.class,StudentBiz.REMOTE,IStudentService::getGrade);
    serviceExecutor.execute(IStudentService.class,StudentBiz.REMOTE,IStudentService::getName);
  }


  @Test
  public void testHelloService(){
    extensionExecutor.executeVoid(HelloServiceExtPt.class, BizScenario.valueOf("v1"),HelloServiceExtPt::say );

    String v2 = extensionExecutor.execute(HelloServiceExtPt.class, BizScenario.valueOf("v2"),
        helloService -> {
          return helloService.getName();
        });

    System.out.println(v2);
  }

}
