package com.school.grade.mapper;

import com.school.grade.entity.GetUserListParam;
import com.school.grade.entity.GradeUser;
import com.school.grade.entity.LoginParam;

import java.util.List;

public interface GradeUserMapper {

    GradeUser selectGradeUserById(Integer userId);

    GradeUser selectGradeUser(LoginParam info);

    GradeUser selectGradeUserByAccount(String account);

    int updateGradeUserInfo(GradeUser user);

    List<GradeUser> selectGradeUserList(GetUserListParam param);

    int deleteGradeUser(Integer userId);

    int insertGradeUser(GradeUser user);

    List<GradeUser> selectTeacherList();

    List<GradeUser> selectStudentList();
}
