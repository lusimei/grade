package com.school.grade.service;

import com.school.grade.entity.LoginParam;

import java.util.Map;

public interface UserService {

    Map<String, Object> userLogin(LoginParam info);

}
