package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 用户的类型
 * @author chaochis
 */
@Getter
public enum UserType implements BaseEnum {
  WindUser(0, "wind系统用户"),
  WxUser(1, "微信用户");
  @EnumValue
  private final Integer value;
  private final String text;
  UserType(Integer value, String text) {
    this.value = value;
    this.text = text;
  }
}
