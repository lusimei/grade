package com.school.grade.controller;
import com.school.grade.entity.*;
import com.school.grade.service.ScoreService;
import com.school.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * @author weston
 * @version 版本1.0
 */

@Controller
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    /**
     * 查询今年所有周列表
     */
    @RequestMapping(value = "getWeekByYear", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getWeekByYear() {
        return scoreService.getWeekByYear();
    }

    /**
     * 查询评分列表
     */
    @RequestMapping(value = "getGradeScoreList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> getGradeScoreList(GetGradeScoreListParam param) {
        return scoreService.getGradeScoreList(param);
    }

}
