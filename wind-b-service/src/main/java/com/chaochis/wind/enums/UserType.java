package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 用户的类型
 * @author chaochis
 */

public enum UserType {
  /**
   * 0 - wind系统的用户, 1 - 微信用户
   */
  WindUser(0),
  WxUser(1);
  @EnumValue
  private final Integer value;
  UserType(Integer value) {
    this.value = value;
  }
}
