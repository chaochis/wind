package com.chaochis.wind.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * wind3_user
 * @author chao
 */
@Data
@TableName("wind3_user")
public class WindUser implements Serializable {
    /**
     * 用户id
     */
    @TableId("user_id")
    private String userId;
    /**
     * 用户登录名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户昵称
     */
    @TableField("user_nick_name")
    private String userNickName;
    /**
     * 用户邮箱
     */
    @TableField("user_email")
    private String userEmail;
    /**
     * 用户手机号
     */
    @TableField("user_mobile")
    private String userMobile;
    /**
     * 用户加密密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 盐值
     */
    @TableField("user_password_salt")
    private String userPasswordSalt;
    /**
     * 用户等级
     */
    @TableField("user_level")
    private Integer userLevel;
    /**
     * 用户状态
     */
    /*@TableField("user_status")
    private DataStatus userStatus;*/

    private static final long serialVersionUID = 1L;
}
