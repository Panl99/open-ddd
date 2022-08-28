package com.only4play.security.util;

import com.only4play.security.base.BaseJwtUser;
import java.util.Objects;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityUtils {

  public static String getCurrentUsername(){
    String temp = "";
    try {
      BaseJwtUser jwtUser = getJwtUser();
      if(Objects.nonNull(jwtUser)){
        return jwtUser.getUsername();
      }else {
        temp =  "-";
      }
    } catch (Exception e) {
      temp = "";
    }
    return temp;
  }

  public static BaseJwtUser getJwtUser(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if(authentication.getClass().isAssignableFrom(AnonymousAuthenticationToken.class)){
      return null;
    }else{
      BaseJwtUser info = (BaseJwtUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      return info;
    }

  }

}
