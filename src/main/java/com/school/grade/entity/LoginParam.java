package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用于映射用户登录时的参数
 */
@Getter
@Setter
public class LoginParam{
    /**
     * 是否记住密码 【0否，1是】
     */
    private Integer remember;
    /**
     * 用户名
     */
    private String accountNumber;
    /**
     * 密码
     */
    private String accountPassword;
}
