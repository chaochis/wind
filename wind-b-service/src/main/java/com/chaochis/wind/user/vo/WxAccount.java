package com.chaochis.wind.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.base.vo.concret.BaseAccount;
import com.chaochis.wind.enums.AccountType;
import com.chaochis.wind.enums.DataStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 微信账户表(token更新不被视为信息更改)
 * @author 刘超/chaochis
 */
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
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private LocalDateTime registerDate;
  /**
   * 最近一次登录的时间
   */
  @TableField("login_date")
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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

  /**
   * 微信账号状态
   */
  @TableField("account_status")
  private DataStatus accountStatus;

  /**
   * 微信账号状态中文解释
   */
  @TableField("account_status_text")
  private String accountStatusText;

  /**
   * 最近一次更新该微信账户信息的人的userId
   */
  @TableField("update_by_id")
  private String updateById;

  /**
   * 最近一次更新该微信账户信息的时间
   */
  @TableField("update_date")
  private LocalDateTime updateDate;

  /**
   * 账号类别
   */
  @TableField("account_type")
  private AccountType accountType;

  /**
   * 账号类别中文解释
   */
  @TableField("account_type_text")
  private String accountTypeText;
}
