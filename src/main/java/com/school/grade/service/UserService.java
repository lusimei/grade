package com.school.grade.service;

import com.school.grade.entity.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String, Object> userLogin(LoginParam info, HttpServletRequest request,
                                  HttpServletResponse response, Model model);

    Map<String,Object> getUserInfo(String account,HttpServletResponse response);

    Map<String,Object> updatePassword(UpdatePasswordParam param);

    Map<String,Object> getUserList(GetUserListParam param);

    Map<String,Object> removeUser(Integer userId);

    Map<String,Object> getGradeUser(Integer userId);

    Map<String,Object> addGradeUser(GradeUser user);

    Map<String,Object> updateGradeUser(GradeUser user);

    Map<String,Object> getGradeRelationList(GetGradeRelationListParam param);

    Map<String,Object> removeGradeRelation(Integer grId);

    Map<String,Object> getTeacherAndStudentList();

    Map<String,Object> addGradeRelation(List<GradeRelation> list);

    Map<String,Object> getTeacherList();

    Map<String,Object> getStudentList(Integer teacherId);
}
