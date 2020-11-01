package com.school.grade.controller;
import com.school.grade.entity.*;
import com.school.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * @author weston
 * @version 版本1.0
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 管理员登录
     */
    @RequestMapping(value="userLogin",produces = "application/json; charset=utf-8")
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

    /**
     * 根据用户ID获取用户信息
     */
    @RequestMapping(value = "getGradeUser/{userId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getGradeUser(@PathVariable("userId") Integer userId) {
        return userService.getGradeUser(userId);
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "updatePassword", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> updatePassword(@RequestBody UpdatePasswordParam param) {
        return userService.updatePassword(param);
    }

    /**
     * 查询用户列表
     */
    @RequestMapping(value = "getUserList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getUserList(@RequestBody GetUserListParam param) {
        return userService.getUserList(param);
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "removeUser/{userId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> removeUser(@PathVariable("userId") Integer userId) {
        return userService.removeUser(userId);
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "addGradeUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> addGradeUser(@RequestBody GradeUser user) {
        return userService.addGradeUser(user);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "updateGradeUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> updateGradeUser(@RequestBody GradeUser user) {
        return userService.updateGradeUser(user);
    }

    /**
     * 查询属系列表
     */
    @RequestMapping(value = "getGradeRelationList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getGradeRelationList(@RequestBody GetGradeRelationListParam param) {
        return userService.getGradeRelationList(param);
    }

    /**
     * 删除属系
     */
    @RequestMapping(value = "removeGradeRelation/{grId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> removeGradeRelation(@PathVariable("grId") Integer grId) {
        return userService.removeGradeRelation(grId);
    }

    /**
     * 查询教师学生列表
     */
    @RequestMapping(value = "getTeacherAndStudentList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getTeacherAndStudentList() {
        return userService.getTeacherAndStudentList();
    }

    /**
     * 添加属系
     */
    @RequestMapping(value = "addGradeRelation", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> addGradeRelation(@RequestBody List<GradeRelation> list) {
        return userService.addGradeRelation(list);
    }

    /**
     * 查询教师列表
     */
    @RequestMapping(value = "getTeacherList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getTeacherList() {
        return userService.getTeacherList();
    }

    /**
     * 根据教师ID查询学生列表
     */
    @RequestMapping(value = "getStudentList/{teacherId}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getStudentList(@PathVariable("teacherId") Integer teacherId) {
        return userService.getStudentList(teacherId);
    }
}
