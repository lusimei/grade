package com.school.grade.service.serviceImpl;

import com.school.grade.entity.GradeStudents;
import com.school.grade.entity.GradeTeachers;
import com.school.grade.entity.LoginParam;
import com.school.grade.mapper.GradeStudentsMapper;
import com.school.grade.mapper.GradeTeachersMapper;
import com.school.grade.service.UserService;
import com.school.grade.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weston
 * @version 版本1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private GradeTeachersMapper gradeTeachersMapper;
	@Autowired
	private GradeStudentsMapper gradeStudentsMapper;

	@Override
	public Map<String, Object> userLogin(LoginParam info) {
		Map<String, Object> retobj = new HashMap<String, Object>();
		info.setAccountPassword(MD5.getMD5Str(info.getAccountPassword()));
		if(info.getLoginType() == 1){
			GradeStudents students = gradeStudentsMapper.selectStudentsInfo(info);
			if(students != null){
				retobj.put("info", students);
				retobj.put("code",1);
			}else{
				retobj.put("code",500);
				retobj.put("msg", "帐号或者密码错误");
			}
		}else{
			GradeTeachers teachers = gradeTeachersMapper.selectTeacherInfo(info);
			if(teachers != null){
				retobj.put("info", teachers);
				retobj.put("code",1);
			}else{
				retobj.put("code",500);
				retobj.put("msg", "帐号或者密码错误");
			}
		}
		return retobj;
	}
}
