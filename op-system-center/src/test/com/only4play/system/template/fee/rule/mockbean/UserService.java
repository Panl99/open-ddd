package com.only4play.system.template.fee.rule.mockbean;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  public UserInfo getUserInfo(Long userId){
    UserInfo userInfo = new UserInfo();
    userInfo.setUserId(userId);
    userInfo.setPlusNo(RandomUtil.randomString(4));
    userInfo.setPlus(true);
    return userInfo;
  }

  public  Integer hasEnjoyFreeTimes(Long userId){
    return 1;
  }


  @Data
  public static class UserInfo{
    private String plusNo;
    private boolean isPlus;
    private Long userId;
  }
}
