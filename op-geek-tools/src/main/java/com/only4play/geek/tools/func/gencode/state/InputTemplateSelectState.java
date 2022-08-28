package com.only4play.geek.tools.func.gencode.state;

import cn.hutool.core.lang.Validator;
import cn.hutool.extra.spring.SpringUtil;
import com.only4play.geek.tools.func.gencode.GenCodeScene;
import com.only4play.geek.tools.func.gencode.registry.TemplateRegistry;
import com.only4play.geek.tools.utils.PromptUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputTemplateSelectState implements GenCodeState {

  private final GenCodeScene codeScene;

  @Override
  public void onEnter(String input) {
    //这里的提示信息做成动态的，配置文件加的话
    String tipInfo = SpringUtil.getBean(TemplateRegistry.class).getTipInfo();
    PromptUtil.changePrompt(tipInfo);
  }

  @Override
  public void complete(String input) {
    if (!Validator.isNumber(input)) {
      throw new RuntimeException("请输入整数");
    }
    codeScene.getGenInputHolder().setTemplate(Integer.valueOf(input));
  }
}