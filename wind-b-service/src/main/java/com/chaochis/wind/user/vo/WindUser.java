package com.chaochis.wind.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.enums.UserSex;
import lombok.Data;

import java.io.Serializable;

/**
 * wind3_user
 * @author chao
 */
@Data
@TableName("wind_user")
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
    @TableField("user_status")
    private DataStatus userStatus;

    /**
     * 用户性别
     */
    @TableField("user_sex")
    private UserSex userSex;

    /**
     * 用户性别中文
     */
    @TableField("user_sex_text")
    private String userSexText;


    private static final long serialVersionUID = 1L;
}
