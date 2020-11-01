package com.school.grade.service;

import com.school.grade.entity.*;
import java.util.List;
import java.util.Map;

public interface ScoreService {

    Map<String, Object> getWeekByYear();

    Map<String,Object> getGradeScoreList(GetGradeScoreListParam param);

    Map<String,Object> addGradeScore(List<GradeScore> list);

    Map<String,Object> removeScore(Integer gsId);

    Map<String,Object> updateGradeScore(GradeScore score);

    Map<String,Object> getGradeScore(Integer studentId,Integer weekNumber);
}
