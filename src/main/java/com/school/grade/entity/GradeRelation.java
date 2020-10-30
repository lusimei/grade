package com.school.grade.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeRelation {

    /**
     * 关系表ID
     */
    private Integer grId;
    /**
     * 老师ID
     */
    private Integer teacherId;
    /**
     * 老师名字
     */
    private String teacherName;
    /**
     * 学生ID
     */
    private Integer studentId;
    /**
     * 学生名字
     */
    private String studentName;

}
