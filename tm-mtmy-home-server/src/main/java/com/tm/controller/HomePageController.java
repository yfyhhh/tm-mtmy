package com.tm.controller;

import com.tm.entity.vo.SelectedActivitiesVo;
import com.tm.result.Result;
import com.tm.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/homePage")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    /**
     * 精选活动
     * @return
     */
    @PostMapping("selectedActivities")
    public Result selectedActivities(){
        return Result.SUCCESS(homePageService.selectedActivities());
    }

    /**
     * 每日必选，根据年龄段，推荐对应的商品
     * @return
     */
    @PostMapping("dailyRequired")
    public Result dailyRequired(Integer userAge){
        return Result.SUCCESS(homePageService.dailyRequired(userAge));
    }

    /**
     * 查看视频中的所有视频，前端传过来当前页数和每页条数
     * @param pageNow
     * @param pageSize
     * @return
     */
    @PostMapping("homeVideo")
    public Result homeVideo(Integer pageNow,Integer pageSize){
        return Result.SUCCESS(homePageService.homeVideo(pageNow, pageSize));
    }

    /**
     * 主页有好货
     * @return
     */
    @PostMapping("haveNiceGoods")
    public Result haveNiceGoods(){
        return Result.SUCCESS(homePageService.haveNiceGoods());
    }

    /**
     * 美学院推荐，展示最近的，同时则展示关注的
     * @param userId
     * @param dateTime
     * @return
     */
    @PostMapping("BeautifulSchool")
    public Result BeautifulSchool(Long userId, Long dateTime){
        return Result.SUCCESS(homePageService.BeautifulSchool(userId,dateTime));
    }

}
