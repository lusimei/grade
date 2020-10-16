package com.school.grade.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeStudentsMapper {

    int deleteByPrimaryKey(Integer clerkId);

}