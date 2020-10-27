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

    /**
     * 管理员登录
     */
    @RequestMapping(value="/userLogin",produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> userLogin(@RequestBody LoginParam info,HttpServletRequest request,
                            HttpServletResponse response, Model model) {
        return userService.userLogin(info,request,response,model);
    }

    /**
     * 根据登录账号获取用户信息与权限
     */
    @RequestMapping(value = "getUserInfo", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getUserInfo(@RequestParam("account") String account,HttpServletResponse response) {
        return userService.getUserInfo(account, response);
    }

}
