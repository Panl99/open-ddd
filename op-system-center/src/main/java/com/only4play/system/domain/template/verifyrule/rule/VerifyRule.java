package com.only4play.system.domain.template.verifyrule.rule;

import java.util.Optional;

public interface VerifyRule {

    Optional<String> verify(String input);

    VerifyTypeEnum getVerifyType();


}
