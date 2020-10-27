package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GradeUser {
    /**
     * 用户表ID
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 职工编号(帐号)
     */
    private String accountNumber;
    /**
     * 密码
     */
    private String accountPassword;
    /**
     * 帐号类别【1超级管理员，2老师，3学生】
     */
    private Integer accountType;
    /**
     * 状态 【0删除 ，1正常】
     */
    private Integer status;
    /**
     * 性别,默认男F女M
     */
    private String userSex;
    /**
     * 联系邮箱
     */
    private String userEmail;
    /**
     * 联系手机
     */
    private String cellphone;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
