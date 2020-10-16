package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class GradeStudents {
    /**
     * 学员ID
     */
    private Integer studentId;
    /**
     * 学员名
     */
    private String studentName;
    /**
     * 院友号
     */
    private String studentNumber;
    /**
     * 性别(F女，M男)
     */
    private String studentSex;
    /**
     * 性别(F女，M男)
     */
    private  Integer status;
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}