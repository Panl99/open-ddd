package com.only4play.common.constants;

/**
 * @author Gim
 * @Date 2019-09-12
 */
public interface BaseEnum<T extends Enum<T> & BaseEnum<T>> {

  /**
   * 获取code码存入数据库
   *
   * @return 获取编码
   */
  Integer getCode();

  /**
   * 获取编码名称，便于维护
   *
   * @return 获取编码名称
   */
  String getName();

  /**
   * 根据code码获取枚举
   *
   * @param cls enum class
   * @param code enum code
   * @return get enum
   */
  static <T extends Enum<T> & BaseEnum<T>> T parseByCode(Class<T> cls, Integer code) {
    for (T t : cls.getEnumConstants()) {
      if (t.getCode().intValue() == code.intValue()) {
        return t;
      }
    }
    return null;
  }

}