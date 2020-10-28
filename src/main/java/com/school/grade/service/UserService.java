package com.school.grade.service;

import com.school.grade.entity.LoginParam;
import com.school.grade.entity.UpdatePasswordParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {

    Map<String, Object> userLogin(LoginParam info, HttpServletRequest request,
                                  HttpServletResponse response, Model model);

    Map<String,Object> getUserInfo(String account,HttpServletResponse response);

    Map<String,Object> updatePassword(UpdatePasswordParam param);
}
