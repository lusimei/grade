package com.school.grade.controller;

import com.school.grade.entity.GradeScore;
import com.school.grade.entity.LoginParam;
import com.school.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author weston
 * @version 版本1.0
 */

@Controller
public class AdminController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "welcome to grade";
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

    @RequestMapping("/score-list")
    public String scoreList() {
        return "score-list";
    }

    @RequestMapping("/relation-list")
    public String relationList() {
        return "relation-list";
    }

    @RequestMapping("/score-add")
    public String scoreAdd() {
        return "score-add";
    }

    @RequestMapping("/personal-score")
    public String personalScore() {
        return "personal-score";
    }
}
