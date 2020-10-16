package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class GradeTeachers {
    /**
     * 职员信息表ID
     */
    private Integer clerkId;
    /**
     * 职工名字
     */
    private String clerkName;
    /**
     * 职工编号
     */
    private String clerkNumber;
    /**
     * 状态-->1:在职，0：删除
     */
    private Integer clerkStatus;
    /**
     * 性别,默认男F女M
     */
    private String clerkSex;
    /**
     * 联系邮箱
     */
    private String clerkEmail;
    /**
     * 联系手机
     */
    private String cellphone;
    /**
     * 入职时间
     */
    private Date entryTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 用户名
     */
    private String accountName;
    /**
     * 登录密码
     */
    private String accountPassword;
    /**
     * 帐号类别
     */
    private Integer accountType;
}