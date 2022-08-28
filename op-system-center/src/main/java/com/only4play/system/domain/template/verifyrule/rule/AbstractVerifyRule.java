package com.only4play.system.domain.template.verifyrule.rule;

public abstract class AbstractVerifyRule implements VerifyRule{

    private final VerifyTypeEnum verifyTypeEnum;

    protected AbstractVerifyRule(VerifyTypeEnum verifyTypeEnum) {
        this.verifyTypeEnum = verifyTypeEnum;
    }

    @Override
    public VerifyTypeEnum getVerifyType() {
        return this.verifyTypeEnum;
    }
}
