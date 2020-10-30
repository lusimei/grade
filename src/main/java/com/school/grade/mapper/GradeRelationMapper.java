package com.school.grade.mapper;

import com.school.grade.entity.GradeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeRelationMapper {

    List<GradeRelation> selectGradeRelationList(@Param("teacherName")String teacherName,
                                                @Param("studentName")String studentName);

    int insertGradeRelation(GradeRelation relation);

    int deleteGradeRelation(Integer grId);

    GradeRelation selectRelationById(@Param("teacherId")Integer teacherId,
                                     @Param("studentId")Integer studentId);
}
