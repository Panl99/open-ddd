package com.only4play.system.domain.template.verifyrule.rule;

import com.only4play.system.infrastructure.constants.TemplateErrorCode;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class TextLengthVerifyRule extends AbstractVerifyRule {

    @Setter
    @Getter
    private Integer length;

    public TextLengthVerifyRule() {
        super(VerifyTypeEnum.TEXT_LENGTH);
    }

    @Override
    public Optional<String> verify(String input) {
        if (!StringUtils.isEmpty(input)) {
            if (input.length() > length) {
                Optional.of(TemplateErrorCode.INPUT_TOO_LONG.getName());
            }
        }
        return Optional.empty();
    }
}
