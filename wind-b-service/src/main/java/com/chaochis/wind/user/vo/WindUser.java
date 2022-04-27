package com.chaochis.wind.user.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.base.vo.BaseVo;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.enums.UserSex;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * wind3_user
 * @author chao
 */
@Getter
@Setter
@ToString
@TableName("wind_user")
public class WindUser implements Serializable, BaseVo {
    /**
     * 用户id
     */
    @TableId("user_id")
    private String userId;
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
     * 用户昵称
     */
    @TableField("user_nick_name")
    private String userNickName;

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

    /**
     * 用户头像地址
     */
    @TableField("user_avatar")
    private String userAvatar;

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
     * 用户真实姓名
     */
    @TableField("user_real_name")
    private String userRealName;

    /**
     * 用户状态中文解释
     */
    @TableField("user_status_text")
    private String userStatusText;


    private static final long serialVersionUID = 1L;
}
