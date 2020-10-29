package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserListParam {
    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 用户类型
     */
    private Integer grId;
    /**
     * 用户名/编号
     */
    private String userName;

}
