package com.only4play.geek.tools.func.gencode.shell;

import com.only4play.geek.tools.func.gencode.GenCodeScene;
import com.only4play.geek.tools.prompt.CommandPrompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author gim
 */
@ShellComponent
public class GenCodeShell {

  private GenCodeScene genCodeScene;

  @Autowired
  private CommandPrompt commandPrompt;

  @ShellMethod("开始进行代码生成")
  public String gencode(@ShellOption(defaultValue = "1") String df) {
    this.genCodeScene = new GenCodeScene();
    genCodeScene.completeInput("");
    return commandPrompt.getDisplay();
  }


  @ShellMethod("输入参数")
  public String g(String param) {
    //可以加一些校验，返回一些验证信息，自己用的话没有必要
    genCodeScene.completeInput(param);
    return commandPrompt.getDisplay();
  }


}
