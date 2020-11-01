package com.school.grade.service.serviceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.grade.entity.*;
import com.school.grade.mapper.GradePermissionMapper;
import com.school.grade.mapper.GradeRelationMapper;
import com.school.grade.mapper.GradeRoleMapper;
import com.school.grade.mapper.GradeUserMapper;
import com.school.grade.service.UserService;
import com.school.grade.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weston
 * @version 版本1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private GradeUserMapper gradeUserMapper;

    @Autowired
    private GradePermissionMapper gradePermissionMapper;

    @Autowired
    private GradeRoleMapper gradeRoleMapper;

    @Autowired
    private GradeRelationMapper gradeRelationMapper;

	@Override
	public Map<String, Object> userLogin(LoginParam info, HttpServletRequest request,
                                         HttpServletResponse response, Model model) {
        Map<String, Object> result = new HashMap<String, Object>();
	    if (info == null) {
            result.put("code",500);
            return result;
        }
        String pwd = info.getAccountPassword();
        info.setAccountPassword(MD5.getMD5Str(info.getAccountPassword()));
        GradeUser user = gradeUserMapper.selectGradeUser(info);
        if(user != null){
            Cookie cookie1 = new Cookie("accountNumber", user.getAccountNumber());
            cookie1.setPath("/");
            cookie1.setMaxAge(Integer.MAX_VALUE);
            Cookie cookie3 = new Cookie("accountType",user.getAccountType().toString());
            cookie3.setPath("/");
            cookie3.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie1);
            response.addCookie(cookie3);
            request.getSession().setMaxInactiveInterval(Integer.MAX_VALUE);
            request.getSession().setAttribute("user", user);
            // 记住密码
            if (info.getRemember() == 1) {
                Cookie cookie2 = new Cookie("password",pwd);
                cookie2.setPath("/");
                cookie2.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie2);
            } else {
                Cookie cookie2 = new Cookie("password", null);
                cookie2.setPath("/");
                cookie2.setMaxAge(0);
                response.addCookie(cookie2);
            }
            result.put("code",1);
        }else{
            result.put("code",500);
        }
        return result;
	}

    @Override
    public Map<String, Object> getUserInfo(String account,HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        GradeUser user = gradeUserMapper.selectGradeUserByAccount(account);
        if (user != null) {
            List<GradePermission> gps = gradePermissionMapper.selectPermission(user.getAccountType());
            result.put("code",1);
            result.put("userInfo", user);
            result.put("role",gradeRoleMapper.selectGradeRole(user.getAccountType()));
            result.put("permissions", gps);

            Cookie cookie1 = new Cookie("clerkId", user.getUserId().toString());
            cookie1.setPath("/");
            cookie1.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie1);

            Cookie cookie2 = null;
            try {
                cookie2 = new Cookie("clerkName", URLEncoder.encode(user.getUserName(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            cookie2.setPath("/");
            cookie2.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie2);
        } else {
            result.put("code", "500");
        }
        return result;
    }

    @Override
    public Map<String, Object> getGradeUser(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code",1);
        result.put("info",gradeUserMapper.selectGradeUserById(userId));
        return result;
    }

    @Override
    public Map<String, Object> updatePassword(UpdatePasswordParam param) {
        Map<String, Object> retobj = new HashMap<String, Object>();
        GradeUser user = gradeUserMapper.selectGradeUserByAccount(param.getAccountNumber());
        if (MD5.getMD5Str(param.getOldPassword()).equals(user.getAccountPassword())) {
            GradeUser gradeUser = new GradeUser();
            gradeUser.setUserId(user.getUserId());
            gradeUser.setAccountPassword(MD5.getMD5Str(param.getNewPassword()));
            gradeUserMapper.updateGradeUserInfo(gradeUser);
            retobj.put("code",1);
        } else {
            retobj.put("code",500);
        }
        return retobj;
    }

    @Override
    public Map<String, Object> getUserList(GetUserListParam param) {
        Map<String, Object> result = new HashMap<String, Object>();
        PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
        if(param.getUserName().length() > 0){
            param.setUserName("%"+param.getUserName()+"%");
        }
        List<GradeUser> list = gradeUserMapper.selectGradeUserList(param);
        PageInfo<GradeUser> page = new PageInfo<>(list);
        result.put("code",1);
        result.put("page",page);
        return result;
    }

    @Override
    public Map<String, Object> removeUser(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        gradeUserMapper.deleteGradeUser(userId);
        result.put("code",1);
        return result;
    }

    @Override
    public Map<String, Object> addGradeUser(GradeUser user) {
        Map<String, Object> result = new HashMap<String, Object>();
        if(user.getAccountPassword() != null && user.getAccountPassword().length() > 0){
            user.setAccountPassword(MD5.getMD5Str(user.getAccountPassword()));
        }else{
            user.setAccountPassword(null);
        }
        gradeUserMapper.insertGradeUser(user);
        result.put("code",1);
        return result;
    }

    @Override
    public Map<String, Object> updateGradeUser(GradeUser user) {
        Map<String, Object> result = new HashMap<String, Object>();
        if(user.getAccountPassword() != null && user.getAccountPassword().length() > 0){
            user.setAccountPassword(MD5.getMD5Str(user.getAccountPassword()));
        }else{
            user.setAccountPassword(null);
        }
        gradeUserMapper.updateGradeUserInfo(user);
        result.put("code",1);
        return result;
    }

    @Override
    public Map<String, Object> getGradeRelationList(GetGradeRelationListParam param) {
        Map<String, Object> result = new HashMap<String, Object>();
        PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
        if(param.getTeacherName().length() > 0){
            param.setTeacherName("%"+param.getTeacherName()+"%");
        }
        if(param.getStudentName().length() > 0){
            param.setStudentName("%"+param.getStudentName()+"%");
        }
        List<GradeRelation> list = gradeRelationMapper
                .selectGradeRelationList(param.getTeacherName(),param.getStudentName());
        PageInfo<GradeRelation> page = new PageInfo<>(list);
        result.put("code",1);
        result.put("page",page);
        return result;
    }

    @Override
    public Map<String, Object> removeGradeRelation(Integer grId) {
        Map<String, Object> result = new HashMap<String, Object>();
        gradeRelationMapper.deleteGradeRelation(grId);
        result.put("code",1);
        return result;
    }

    @Override
    public Map<String, Object> getTeacherAndStudentList() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("teacherList",gradeUserMapper.selectTeacherList());
        result.put("studentList",gradeUserMapper.selectStudentList());
        result.put("code",1);
        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> addGradeRelation(List<GradeRelation> list) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer count = 0;//用于记录已存在属系的数量
        for (int i = 0; i < list.size(); i++) {
            GradeRelation relation = gradeRelationMapper
                    .selectRelationById(list.get(i).getTeacherId(),list.get(i).getStudentId());
            if(relation == null){
                gradeRelationMapper.insertGradeRelation(list.get(i));
            }else {
                count++;
            }
        }
        result.put("code",1);
        result.put("count",count);
        return result;
    }

    @Override
    public Map<String, Object> getTeacherList() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("teacherList",gradeUserMapper.selectTeacherList());
        result.put("code",1);
        return result;
    }

    @Override
    public Map<String, Object> getStudentList(Integer teacherId) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("studentList",gradeUserMapper.selectStudentListById(teacherId));
        result.put("code",1);
        return result;
    }
}
