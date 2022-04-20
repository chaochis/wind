package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.chaochis.wind.base.enums.BaseEnum;
import lombok.Getter;

/**
 * 用户性别
 * @author 刘超/chaochis
 */
@Getter
public enum UserSex implements BaseEnum {
  /**
   * 0 - 未激活状态 1 - 正常状态 2 - 已删除
   */
  Inactivated(0, "未激活"),
  Normal(1, "正常"),
  Deleted(2, "已删除");
  @EnumValue
  private final Integer value;
  private final String text;
  UserSex(Integer value, String text) {
    this.value = value;
    this.text = text;
  }
}
