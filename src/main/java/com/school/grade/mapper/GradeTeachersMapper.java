package com.school.grade.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeTeachersMapper {

    int deleteByPrimaryKey(Integer accountId);

}