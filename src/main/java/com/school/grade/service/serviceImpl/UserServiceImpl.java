package com.school.grade.service.serviceImpl;
import com.school.grade.entity.GradePermission;
import com.school.grade.entity.GradeUser;
import com.school.grade.entity.LoginParam;
import com.school.grade.entity.UpdatePasswordParam;
import com.school.grade.mapper.GradePermissionMapper;
import com.school.grade.mapper.GradeRoleMapper;
import com.school.grade.mapper.GradeUserMapper;
import com.school.grade.service.UserService;
import com.school.grade.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
