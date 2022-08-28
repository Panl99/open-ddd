package com.only4play.system.domain.asset.assetrecord;


import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum InOutType implements BaseEnum<InOutType> {

    IN(1, "入库"),
    OUT(2, "出库");

    InOutType(Integer code, String name) {
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

    public static Optional<InOutType> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(InOutType.class, code));
    }

}