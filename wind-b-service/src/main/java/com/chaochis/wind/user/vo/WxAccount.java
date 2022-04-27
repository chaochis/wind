package com.chaochis.wind.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.base.vo.concret.BaseAccount;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@TableName("wx_account")
public class WxAccount implements Serializable, BaseAccount {
  /**
   * 账户id
   */
  @TableId("account_id")
  private String accountId;
  /**
   * 微信的union_id
   */
  @TableField("union_id")
  private String unionId;
  /**
   * 微信小程序的open_id
   */
  @TableField("open_id")
  private String openId;
  /**
   * 微信昵称
   */
  @TableField("wx_nick_name")
  private String wxNickName;
  /**
   * 微信昵称
   */
  @TableField("wx_avatar")
  private String wxAvatar;
  /**
   * 注册ip地址
   */
  @TableField("register_ip")
  private String registerIp;

  /**
   * 最近一次登录的ip
   */
  @TableField("login_ip")
  private String loginIp;

  /**
   * 注册时间
   */
  @TableField("register_date")
  private LocalDateTime registerDate;
  /**
   * 最近一次登录的时间
   */
  @TableField("login_date")
  private LocalDateTime loginDate;

  /**
   * 最近一次登录时携带的token
   */
  @TableField("token")
  private String token;

  /**
   * 绑定wind用户的user_id
   */
  @TableField("user_id")
  private String userId;
}
