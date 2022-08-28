package com.only4play.system.template.matcher;

import net.bytebuddy.matcher.ElementMatcher.Junction.AbstractBase;

public class AgeMatcher extends AbstractBase<UserContext> {

  @Override
  public boolean matches(UserContext userContext) {
    if(userContext.getAge() > 3){
      return true;
    }
    return false;
  }
}
