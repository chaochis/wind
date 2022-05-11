package com.chaochis.wind.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.chaochis.wind.base.enums.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 登录账号类别的枚举
 * @author chaochis
 */
@Getter
public enum AccountType implements BaseEnum {
  UserName(0, "用户名"),
  PhoneNumber(1, "手机号"),
  Email(2, "邮箱"),
  WxAccount(3, "微信账户");
  @EnumValue
  @JsonValue
  private final Integer value;
  private final String text;
  AccountType(Integer value, String text) {
    this.value = value;
    this.text = text;
  }
}
