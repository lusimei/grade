package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeRolePermission {
    /**
     * 角色权限关系表ID
     */
    private Integer grpId;
    /**
     * 角色ID
     */
    private Integer grId;
    /**
     * 权限ID
     */
    private Integer gpId;
}
