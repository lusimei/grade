package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用于映射用户登录时的参数
 */
@Getter
@Setter
public class LoginParam{

    private Integer loginType;

    private String accountName;

    private String accountPassword;
}
