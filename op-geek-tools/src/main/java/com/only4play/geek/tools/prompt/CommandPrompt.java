package com.only4play.geek.tools.prompt;

import com.only4play.geek.tools.constants.CommandConstants;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author gim
 * 控制台显示什么
 */
@Data
@Component
public class CommandPrompt {

  private String display = CommandConstants.INPUT_DEFAULT;

}
