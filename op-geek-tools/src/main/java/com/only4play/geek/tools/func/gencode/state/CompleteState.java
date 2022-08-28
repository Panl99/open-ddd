package com.only4play.geek.tools.func.gencode.state;

import com.only4play.geek.tools.constants.CommandConstants;
import com.only4play.geek.tools.func.gencode.GenCodeScene;
import com.only4play.geek.tools.func.gencode.holder.GenInputHolder;
import com.only4play.geek.tools.utils.CmdUtil;
import com.only4play.geek.tools.utils.PromptUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompleteState implements GenCodeState {

  private final GenCodeScene genCodeScene;

  @Override
  public void onEnter(String input) {
    PromptUtil.changePrompt(CommandConstants.COMPLETE);
    GenInputHolder userInput = genCodeScene.getGenInputHolder();
    CmdUtil.mavenGenerate(userInput);
  }

  @Override
  public void complete(String input) {

  }
}
