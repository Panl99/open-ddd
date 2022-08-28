package com.only4play.system.domain.template.verifyrule.rule;


import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum VerifyTypeEnum implements BaseEnum<VerifyTypeEnum> {

    REGEX(1, "正则校验"),
    TEXT_LENGTH(2, "文本长度"),
    MIN_VALUE(3, "最小值"),
    MAX_VALUE(4, "最大值"),
    RANGE(5, "范围校验"),
    PREFIX(6,"前缀"),
    SUFFIX(7,"后缀")
    ;

    VerifyTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static Optional<VerifyTypeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(VerifyTypeEnum.class, code));
    }

}