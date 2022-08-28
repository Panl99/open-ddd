package com.only4play.system.domain.template.verifyrule.rule;

import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class SuffixVerifyRule extends AbstractVerifyRule{

    @Setter
    @Getter
    private String suffix;

    public SuffixVerifyRule() {
        super(VerifyTypeEnum.SUFFIX);
    }

    @Override
    public Optional<String> verify(String input) {
        boolean b = StringUtils.endsWith(input, suffix);
        if(!b){
            return Optional.of("后缀不匹配，后缀应该为:" + suffix);
        }
        return Optional.empty();
    }
}
