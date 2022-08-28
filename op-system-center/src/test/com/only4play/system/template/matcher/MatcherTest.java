package com.only4play.system.template.matcher;

import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;

public class MatcherTest {

  @Test
  public void testMatcher(){
    UserContext userContext = new UserContext();
    userContext.setAge(5);
    userContext.setName("111");
    boolean matches = ElementMatchers.any()
        .and(new UserNameMatcher())
        .and(new AgeMatcher())
        .matches(userContext);
    System.out.println(matches);

    UserContext userContext2 = new UserContext();
    userContext2.setAge(5);
    userContext2.setName("112");
    boolean matches2 = ElementMatchers.any().and(new UserNameMatcher()).and(new AgeMatcher())
        .matches(userContext2);
    System.out.println(matches2);



  }

}
