package com.only4play.system.domain.template.templateitem;

import com.only4play.common.constants.BaseEnum;
import java.util.Optional;

/**
 * @author gim
 */
public enum InputType implements BaseEnum<InputType> {

  TEXT(1, "文本","TextField"),
  TEXT_AREA(2,"多行文本","TextareaField"),
  DATE(3,"日期","DDDateField"),
  DATA_RANGE(4,"日期范围","DDDateRangeField"),
  SINGLE_SELECT(5,"单选","TextField"),
  MULTI_SELECT(6,"多选","TextField"),
  MONEY_INPUT(7,"金额输入","MoneyField"),
  DIGIT_INPUT(8,"数字输入","NumberField"),
  FILE_INPUT(9,"文件输入","notSupport"),
  IMAGE_INPUT(10,"图片","notSupport"),
  CITY_SELECT(11,"城市选择","notSupport")
  ;

  InputType(Integer code, String name,String componentName) {
    this.code = code;
    this.name = name;
    this.componentName = componentName;
  }

  private Integer code;
  private String name;
  private String componentName;

  public String getComponentName(){
    return this.componentName;
  }

  @Override
  public Integer getCode() {
    return this.code;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public static Optional<InputType> of(Integer code) {
    return Optional.ofNullable(BaseEnum.parseByCode(InputType.class, code));
  }

}
