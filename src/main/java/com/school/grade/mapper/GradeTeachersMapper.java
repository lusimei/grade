package com.school.grade.mapper;

import com.school.grade.entity.GradeTeachers;
import com.school.grade.entity.LoginParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeTeachersMapper {

    GradeTeachers selectTeacherInfo(LoginParam info);

}