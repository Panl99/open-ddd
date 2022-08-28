package com.only4play.system.infrastructure.constants;


import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

public enum AssetErrorCode implements BaseEnum<AssetErrorCode> {

    ASSET_HAS_IN(10010026,"资产已经入库"),
    ASSET_HAS_OUT(10010027,"资产已经出库"),
    ASSET_CODE_NOT_EXIST(10010028,"资产编码不存在")
    ;

  AssetErrorCode(Integer code, String name) {
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

  public static Optional<AssetErrorCode> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(AssetErrorCode.class, code));
  }

}