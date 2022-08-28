package com.only4play.system.template.matcher;

import java.util.Objects;
import net.bytebuddy.matcher.ElementMatcher.Junction.AbstractBase;

public class UserNameMatcher extends AbstractBase<UserContext> {

  @Override
  public boolean matches(UserContext userContext) {
    if (Objects.equals("111", userContext.getName())) {
      return true;
    } else {
      return false;
    }
  }
}
