package com.only4play.geek.tools.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.only4play.geek.tools.prompt.CommandPrompt;

/**
 * @author gim
 */
public class PromptUtil {

  /**
   * 改变提示信息
   * @param to
   */
  public static void changePrompt(String to){
    CommandPrompt prompt = SpringUtil.getBean(CommandPrompt.class);
    prompt.setDisplay(to);
  }

}
