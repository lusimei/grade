package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordParam {
    /**
     * 职工编号(帐号)
     */
    private String accountNumber;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 原密码
     */
    private String oldPassword;
}
