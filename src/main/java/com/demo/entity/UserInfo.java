package com.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "T_USER_INFO")
@Data
public class UserInfo implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;
    /**
     * 性别
     */
    private int gender;
    /**
     * 手机号
     */
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    /**
     * 语言
     */
    private String language;
    /**
     * 城市
     */
    private String city;
    /**
     * 省份
     */
    private String province;
    /**
     * 国家
     */
    private String country;
    /**
     * 头像地址
     */
    @Column(name = "AVATAR_URL")
    private String avatarUrl;
    /**
     * 用户通用ID
     */
    @Column(name = "UNION_ID")
    private String unionId;
    /**
     * 用户唯一标识
     */
    @Column(name = "OPEN_ID")
    private String openId;
    @Column(name = "session_key")
    private String sessionKey;
}
