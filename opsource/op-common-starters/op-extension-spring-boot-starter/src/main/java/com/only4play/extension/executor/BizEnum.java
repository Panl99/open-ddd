package com.only4play.extension.executor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import lombok.Getter;

/**
 * @author gim
 */
public enum BizEnum implements BizScene {

  /**
   * 默认业务
   */
  DEFAULT_BIZ("default_biz", "默认业务");

  BizEnum(String bizId, String remark) {
    this.bizId = bizId;
    this.remark = remark;
  }

  private String bizId;
  @Getter
  private String remark;

  public static Optional<BizEnum> of(String bizId) {
    return Arrays.stream(BizEnum.values())
        .filter(s -> Objects.equals(s.getBizId(), bizId)).findFirst();
  }

  @Override
  public String getBizId() {
    return this.bizId;
  }
}
