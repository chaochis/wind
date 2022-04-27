package com.chaochis.wind.user.params;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WxUserInfo {
  /**
   * 微信头像
   */
  private String avatarUrl;
  /**
   * 城市
   */
  private String city;
  /**
   * 国家
   */
  private String country;
  /**
   * 性别 0 - 未知 1 - 男 2 - 女
   */
  private Integer gender;
  /**
   * 语言 - 'en': 英文; - 'zh_CN': 简体中文;- 'zh_TW': 繁体中文;
   */
  private String language;

  /**
   * 微信用户昵称
   */
  private String nickName;
}
