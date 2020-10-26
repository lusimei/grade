package com.school.grade.mapper;

import com.school.grade.entity.GradeStudents;
import com.school.grade.entity.LoginParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeStudentsMapper {

    GradeStudents selectStudentsInfo(LoginParam info);

}