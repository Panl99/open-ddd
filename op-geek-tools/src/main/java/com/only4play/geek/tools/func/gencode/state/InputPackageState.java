package com.only4play.geek.tools.func.gencode.state;

import com.only4play.geek.tools.constants.CommandConstants;
import com.only4play.geek.tools.func.gencode.GenCodeScene;
import com.only4play.geek.tools.utils.PromptUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputPackageState implements GenCodeState {

  private final GenCodeScene genCodeScene;

  @Override
  public void onEnter(String input) {
    PromptUtil.changePrompt(CommandConstants.INPUT_PACKAGE);
  }

  @Override
  public void complete(String input) {
    genCodeScene.getGenInputHolder().setPackageName(input);
  }
}
