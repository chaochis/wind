package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 用户性别
 * @author 刘超/chaochis
 */
@Getter
public enum UserSex implements BaseEnum {
  /**
   * 0 - 未激活状态 1 - 男 2 - 女
   */
  Inactivated(0, "未激活"),
  Normal(1, "男"),
  Deleted(2, "女");
  @EnumValue
  private final Integer value;
  private final String text;
  UserSex(Integer value, String text) {
    this.value = value;
    this.text = text;
  }
}
