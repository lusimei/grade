package com.school.grade.controller;
import com.school.grade.entity.LoginParam;
import com.school.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/**
 * @author weston
 * @version 版本1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 管理员登录
     */
    @RequestMapping(value="/userLogin",produces = "application/json; charset=utf-8")
    public Map<String, Object> userLogin(@RequestBody LoginParam info) {
        return userService.userLogin(info);
    }

}
