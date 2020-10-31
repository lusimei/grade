package com.school.grade.mapper;

import com.school.grade.entity.GetGradeScoreListParam;
import com.school.grade.entity.GradeScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeScoreMapper {

    int insertGradeScore(GradeScore score);

    int updateGradeScore(GradeScore score);

    int deleteGradeScore(Integer gsId);

    List<GradeScore> selectGradeScoreList(GetGradeScoreListParam param);

    GradeScore selectScoreByStudentId(@Param("weekNumber")Integer weekNumber,@Param("studentId")Integer studentId);
}
