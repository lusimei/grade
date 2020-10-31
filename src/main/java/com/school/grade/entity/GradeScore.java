package com.school.grade.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GradeScore {
    /**
     * 评分ID
     */
    private Integer gsId;
    /**
     * 教师ID
     */
    private Integer teacherId;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 学生ID
     */
    private Integer studentId;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 国际标准周(如:2040代表2020年第40周)
     */
    private Integer weekNumber;
    /**
     * 纪律分
     */
    private Float disciplineScore;
    /**
     * 学习分
     */
    private Float studyScore;
    /**
     * 卫生分
     */
    private Float healthScore;
    /**
     * 体育分
     */
    private Float sportsScore;
    /**
     * 文娱分
     */
    private Float entertainmentScore;
    /**
     * 平时表现分
     */
    private Float peacetimeScore;
    /**
     * 总平均分
     */
    private Float avgScore;
    /**
     * 备注
     */
    private String comments;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
