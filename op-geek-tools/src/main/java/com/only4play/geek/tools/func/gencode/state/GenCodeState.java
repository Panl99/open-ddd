package com.only4play.geek.tools.func.gencode.state;

/**
 * @author gim
 */
public interface GenCodeState {

  /**
   * 状态进入
   */
  void onEnter(String input);

  /**
   * 完成输入
   * @param input
   */
  void complete(String input);

}
