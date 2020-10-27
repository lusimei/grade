package com.school.grade.mapper;

import com.school.grade.entity.GradeUser;
import com.school.grade.entity.LoginParam;

public interface GradeUserMapper {

    GradeUser selectGradeUser(LoginParam info);

    GradeUser selectGradeUserByAccount(String account);
}
