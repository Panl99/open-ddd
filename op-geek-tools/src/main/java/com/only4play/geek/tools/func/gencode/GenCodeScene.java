package com.only4play.geek.tools.func.gencode;

import com.only4play.geek.tools.func.gencode.holder.GenInputHolder;
import com.only4play.geek.tools.func.gencode.state.CompleteState;
import com.only4play.geek.tools.func.gencode.state.GenCodeState;
import com.only4play.geek.tools.func.gencode.state.InitState;
import com.only4play.geek.tools.func.gencode.state.InputAppNameState;
import com.only4play.geek.tools.func.gencode.state.InputArtifactIdState;
import com.only4play.geek.tools.func.gencode.state.InputGroupState;
import com.only4play.geek.tools.func.gencode.state.InputPackageState;
import com.only4play.geek.tools.func.gencode.state.InputTemplateSelectState;
import lombok.Getter;

/**
 * @author gim
 */
public class GenCodeScene {

  @Getter
  private GenCodeState current;

  @Getter
  private GenInputHolder genInputHolder;

  public GenCodeScene() {
    this.current = new InitState(this);
    this.genInputHolder = new GenInputHolder();
  }

  public void init() {
    this.current.onEnter("");
  }

  public void completeInput(String input) {
    current.complete(input);
    if (this.current.getClass().equals(InitState.class)) {
      stateChange(new InputGroupState(this), input);
    } else if (this.current.getClass().equals(InputGroupState.class)) {
      stateChange(new InputArtifactIdState(this), input);
    } else if (this.current.getClass().equals(InputArtifactIdState.class)) {
      stateChange(new InputAppNameState(this), input);
    } else if (this.current.getClass().equals(
        InputAppNameState.class)) {
      stateChange(new InputTemplateSelectState(this), input);
    } else if (this.current.getClass().equals(
        InputTemplateSelectState.class)) {
      stateChange(new InputPackageState(this), input);
    } else if (this.current.getClass().equals(InputPackageState.class)) {
      stateChange(new CompleteState(this), input);
    }
  }


  public void stateChange(GenCodeState newState, String input) {
    newState.onEnter(input);
    this.current = newState;
  }

}