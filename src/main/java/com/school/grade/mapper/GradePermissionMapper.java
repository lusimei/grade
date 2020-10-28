package com.school.grade.mapper;

import com.school.grade.entity.GradePermission;

import java.util.List;

public interface GradePermissionMapper {

    GradePermission selectGradePermission();

    List<GradePermission> selectPermission(Integer grId);
}
