package com.only4play.geek.tools.prompt;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomPromptProvider implements PromptProvider {

  public static final String PREFIX = "geek-tools";

  @Override
  public AttributedString getPrompt() {
    return new AttributedString(PREFIX + ":>",
        AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
  }

}