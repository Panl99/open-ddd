package com.only4play.system.template.auth;

import com.only4play.system.domain.admin.creator.AdminUserCreator;
import com.only4play.system.domain.admin.service.IAdminUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AuthTest {

  @Autowired
  private IAdminUserService adminUserService;

  @Test
  public void testAddUser(){
    AdminUserCreator creator = new AdminUserCreator();
    creator.setUsername("张三");
    creator.setPhone("13888888888");
    creator.setPassword("123456");
    adminUserService.createAdminUser(creator);
  }

  @Test
  public void testAddUser2(){
    AdminUserCreator creator = new AdminUserCreator();
    creator.setUsername("李四");
    creator.setPhone("13888888889");
    creator.setPassword("111111");
    adminUserService.createAdminUser(creator);
  }


}
