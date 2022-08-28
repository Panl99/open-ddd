package com.only4play.system.domain.template.verifyrule.rule;

import com.only4play.system.infrastructure.constants.TemplateErrorCode;
import java.util.Optional;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.Setter;

public class RegexVerifyRule extends AbstractVerifyRule{

    @Setter
    @Getter
    private String regex;

    public RegexVerifyRule() {
        super(VerifyTypeEnum.REGEX);
    }

    @Override
    public Optional<String> verify(String input) {
        boolean matches = Pattern.matches(this.regex, input);
        if(!matches){
            return Optional.of(TemplateErrorCode.FORMAT_ERROR.getName());
        }else {
            return Optional.empty();
        }

    }
}
