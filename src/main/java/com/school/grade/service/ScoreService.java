package com.school.grade.service;

import com.school.grade.entity.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface ScoreService {

    Map<String, Object> getWeekByYear();

    Map<String,Object> getGradeScoreList(GetGradeScoreListParam param);

}
