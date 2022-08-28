package com.only4play.system.domain.objectsku;


import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum SkuType implements BaseEnum<SkuType> {

    SINGLE(1, "单件"),
    KIT(2, "套件");

    SkuType(Integer code, String name) {
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

    public static Optional<SkuType> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(SkuType.class, code));
    }

}