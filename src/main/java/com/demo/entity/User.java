package com.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "T_USER")
@Data
public class User implements Serializable{
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "CREATE_DATE")
    private Date createDate;
}
