package com.tm.service;

import com.tm.entity.Video;
import com.tm.entity.vo.*;

import java.util.List;

public interface HomePageService {
    List<SelectedActivitiesVo> selectedActivities();

    List<DailyRequiredVo> dailyRequired(Integer userAge);

    List<VideoVo> homeVideo(Integer pageNow, Integer pageSize);

    List<HaveNiceGoodsVo> haveNiceGoods();

    List<BeautifulSchoolVo> BeautifulSchool(Long userId, Long dateTime);
}
