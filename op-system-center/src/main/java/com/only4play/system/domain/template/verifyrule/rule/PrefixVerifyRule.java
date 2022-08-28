package com.only4play.system.domain.template.verifyrule.rule;

import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class PrefixVerifyRule extends AbstractVerifyRule {

    @Setter
    @Getter
    private String prefix;

    public PrefixVerifyRule() {
        super(VerifyTypeEnum.PREFIX);
    }

    @Override
    public Optional<String> verify(String input) {
        boolean b = StringUtils.startsWith(input, prefix);
        if (!b) {
            return Optional.of("前缀不匹配，前缀应该为:" + prefix);
        }
        return Optional.empty();
    }
}
