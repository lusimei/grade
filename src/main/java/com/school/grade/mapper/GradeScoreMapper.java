package com.school.grade.mapper;

import com.school.grade.entity.GetGradeScoreListParam;
import com.school.grade.entity.GradeScore;

import java.util.List;

public interface GradeScoreMapper {

    int insertGradeScore(GradeScore score);

    int updateGradeScore(GradeScore score);

    List<GradeScore> selectGradeScoreList(GetGradeScoreListParam param);
}
