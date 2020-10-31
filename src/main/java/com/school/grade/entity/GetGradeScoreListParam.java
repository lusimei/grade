package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetGradeScoreListParam {
    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 老师名称
     */
    private String teacherName;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 国际标准周
     */
    private Integer weekNumber;
}
