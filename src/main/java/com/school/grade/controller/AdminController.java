package com.school.grade.controller;

import com.school.grade.entity.LoginParam;
import com.school.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @author weston
 * @version 版本1.0
 */

@Controller
public class AdminController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/password-edit")
    public String passwordEdit() {
        return "password-edit";
    }

    @RequestMapping("/user-list")
    public String userList() {
        return "user-list";
    }

}
