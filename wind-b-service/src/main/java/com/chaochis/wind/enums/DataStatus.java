package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.chaochis.wind.base.enums.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 数据状态
 * @author chaochis
 */
@Getter
public enum DataStatus implements BaseEnum {
  /**
   * 0 - 未激活状态 1 - 正常状态 2 - 已删除
   */
  Inactivated(0, "未激活"),
  Normal(1, "正常"),
  Deleted(2, "已删除");
  @EnumValue
  @JsonValue
  private final Integer value;
  private final String text;
  DataStatus(Integer value, String text) {
    this.value = value;
    this.text = text;
  }
}
