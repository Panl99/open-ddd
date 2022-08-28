package com.only4play.geek.tools.func.gencode.state;

import com.only4play.geek.tools.constants.CommandConstants;
import com.only4play.geek.tools.func.gencode.GenCodeScene;
import com.only4play.geek.tools.utils.PromptUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputAppNameState implements GenCodeState {

  private final GenCodeScene genCodeScene;

  @Override
  public void onEnter(String input) {
    PromptUtil.changePrompt(CommandConstants.INPUT_APP_NAME);
  }

  @Override
  public void complete(String input) {
    genCodeScene.getGenInputHolder().setAppName(input);
  }
}
