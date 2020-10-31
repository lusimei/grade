package com.school.grade.service.serviceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.grade.entity.*;
import com.school.grade.mapper.*;
import com.school.grade.service.ScoreService;
import com.school.grade.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author weston
 * @version 版本1.0
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private GradeScoreMapper gradeScoreMapper;

    @Override
    public Map<String, Object> getWeekByYear() {
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Week> weekList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String yearString = String.valueOf(year).substring(2, 4);
        String[] days = BaseUtils.getWeekByYear(year);
        for (int i = 0; i < days.length; i++) {
            String date1 = "";
            try {
                Date date = BaseUtils.getDateAfter(sdf.parse(days[i]), 6);
                date1 = sdf.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Week week = new Week();
            //format("%02d")格式化为至少2位十进制整数
            week.setId(yearString + String.format("%02d", i + 1));
            week.setDate("W" + yearString + String.format("%02d", i + 1) + " (" + days[i] + "~" + date1 + ")");
            weekList.add(week);
        }
        map.put("list", weekList);
        return map;
    }

    @Override
    public Map<String, Object> getGradeScoreList(GetGradeScoreListParam param) {
        Map<String, Object> result = new HashMap<String, Object>();
        PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
        if(param.getTeacherName().length() > 0){
            param.setTeacherName("%"+param.getTeacherName()+"%");
        }
        if(param.getStudentName().length() > 0){
            param.setStudentName("%"+param.getStudentName()+"%");
        }
        List<GradeScore> list = gradeScoreMapper.selectGradeScoreList(param);
        PageInfo<GradeScore> page = new PageInfo<>(list);
        result.put("code",1);
        result.put("page",page);
        return result;
    }

    @Override
    @Transactional
    public Map<String, Object> addGradeScore(List<GradeScore> list) {
        Map<String, Object> result = new HashMap<String, Object>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(gradeScoreMapper
                    .selectScoreByStudentId(list.get(i).getWeekNumber(),list.get(i).getStudentId()) == null){
                gradeScoreMapper.insertGradeScore(list.get(i));
            }else{
                count++;
            }
        }
        result.put("code",1);
        result.put("count",count);
        return result;
    }

    @Override
    public Map<String, Object> removeScore(Integer gsId) {
        Map<String, Object> result = new HashMap<String, Object>();
        gradeScoreMapper.deleteGradeScore(gsId);
        result.put("code",1);
        return result;
    }
//
//    @Override
//    public Map<String, Object> addGradeUser(GradeUser user) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        if(user.getAccountPassword() != null && user.getAccountPassword().length() > 0){
//            user.setAccountPassword(MD5.getMD5Str(user.getAccountPassword()));
//        }else{
//            user.setAccountPassword(null);
//        }
//        gradeUserMapper.insertGradeUser(user);
//        result.put("code",1);
//        return result;
//    }

}
