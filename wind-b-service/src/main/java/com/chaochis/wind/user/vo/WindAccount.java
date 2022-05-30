package com.chaochis.wind.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.vo.concret.BaseAccount;
import com.chaochis.wind.enums.AccountType;
import com.chaochis.wind.enums.DataStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 风旅系统账户表
 * @author 刘超/chaochis
 */
@Getter
@Setter
@ToString
@TableName("wind_account")
public class WindAccount implements Serializable, BaseAccount {
  /**
   * 账户id
   */
  @TableField("account_id")
  private String accountId;

  /**
   * 登录账户
   */
  @TableField("account_name")
  private String accountName;

  /**
   * 账户类别
   */
  @TableField("account_type")
  private AccountType accountType;

  /**
   * 账户类别中文解释
   */
  @TableField("account_type_text")
  private AccountType accountTypeText;

  /**
   * 账户状态
   */
  @TableField("account_status")
  private DataStatus accountStatus;

  /**
   * 账户状态中文解释
   */
  @TableField("account_status_text")
  private String accountStatusText;
  /**
   * 账户绑定得人得userId
   */
  @TableField("user_id")
  private String userId;

  /**
   * 创建人
   */
  @TableField("create_by_id")
  private String createById;

  /**
   * 创建该记录的时间
   */
  @TableField("create_date")
  private Date createDate;

  /**
   * 更新人的userId
   */
  @TableField("update_by_id")
  private String updateById;

  /**
   * 更新的时间
   */
  @TableField("update_date")
  private Date updateDate;

  /**
   * 最近一次登录ip
   */
  @TableField("login_ip")
  private String loginIp;

  /**
   * 最近一次登录时间
   */
  @TableField("login_date")
  private Date loginDate;
  /**
   * 用户加密密码
   */
  @TableField("account_password")
  private String accountPassword;
  /**
   * 盐值
   */
  @TableField("account_password_salt")
  private String accountPasswordSalt;
}
