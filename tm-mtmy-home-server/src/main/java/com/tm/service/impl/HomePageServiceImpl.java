package com.tm.service.impl;

import com.tm.entity.Video;
import com.tm.entity.vo.*;
import com.tm.mapper.HomePageMapper;
import com.tm.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;

    //用户的职业
    private static Map<String,String> userJobMap = new HashMap();

    //文章的类型
    private static Map<String,String> textType = new HashMap();

    static {
        userJobMap.put("1","时尚辣妈");
        userJobMap.put("2","全职主妇");
        userJobMap.put("3","职场强人");
        textType.put("1","科普教育");
        textType.put("2","新鲜猎奇");
        textType.put("3","两性思考");
    }

    @Override
    public List<SelectedActivitiesVo> selectedActivities() {
        return homePageMapper.selectedActivities();
    }

    @Override
    public List<DailyRequiredVo> dailyRequired(Integer userAge) {
        return homePageMapper.dailyRequired(userAge);
    }

    @Override
    public List<VideoVo> homeVideo(Integer pageNow, Integer pageSize) {
        Integer startIndex = (pageNow - 1) * pageSize;
        return homePageMapper.homeVideo(startIndex, pageSize);
    }

    @Override
    public List<HaveNiceGoodsVo> haveNiceGoods() {
        return homePageMapper.haveNiceGoods();
    }

    @Override
    public List<BeautifulSchoolVo> BeautifulSchool(Long userId, Long dateTime) {
        List<BeautifulSchoolVo> beautifulSchoolVos = new ArrayList<>();
        if(userId != null){
            // 查询用户关注作者今天的文章
            beautifulSchoolVos = homePageMapper.BeautifulSchoolByUserId(userId, dateTime, (dateTime+86400));
            // 查询用户未关注的作者的文章
            List<BeautifulSchoolVo> beautifulSchoolVos2 = homePageMapper.BeautifulSchoolUnByUserId(userId, dateTime, (dateTime+86400));
            // 数据整合一起然后返回
            beautifulSchoolVos.addAll(beautifulSchoolVos2);
        }else {
            beautifulSchoolVos = homePageMapper.BeautifulSchoolNoLogin(dateTime,(dateTime+86400));
        }
        beautifulSchoolVos.forEach(a -> {
            a.setUserJob(userJobMap.get(a.getUserJobId().toString()));
            a.setTextType(textType.get(a.getTextTypeId().toString()));
        });
        return beautifulSchoolVos;
    }
}
