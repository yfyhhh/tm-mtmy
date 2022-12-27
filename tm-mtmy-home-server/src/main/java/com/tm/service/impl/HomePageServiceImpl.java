package com.tm.service.impl;

import com.alibaba.fastjson.JSON;
import com.tm.entity.Business;
import com.tm.entity.TmMtmyProvince;
import com.tm.entity.Video;
import com.tm.entity.dto.NearShopsDTO;
import com.tm.entity.vo.*;
import com.tm.mapper.HomePageMapper;
import com.tm.service.HomePageService;
import com.tm.utils.CalculateDistanceUtil;
import com.tm.utils.ConvertLatLngIntoRegion;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * 精选活动
     * @return
     */
    @Override
    public List<SelectedActivitiesVo> selectedActivities() {
        return homePageMapper.selectedActivities();
    }

    /**
     * 每日必选
     * @param userAge
     * @return
     */
    @Override
    public List<DailyRequiredVo> dailyRequired(Integer userAge) {
        return homePageMapper.dailyRequired(userAge);
    }

    /**
     * 查看视频
     * @param pageNow
     * @param pageSize
     * @return
     */
    @Override
    public List<VideoVo> homeVideo(Integer pageNow, Integer pageSize) {
        Integer startIndex = (pageNow - 1) * pageSize;
        return homePageMapper.homeVideo(startIndex, pageSize);
    }

    /**
     * 有好货推荐
     * @return
     */
    @Override
    public List<HaveNiceGoodsVo> haveNiceGoods() {
        return homePageMapper.haveNiceGoods();
    }

    /**
     * 美学院推荐
     * @param userId
     * @param dateTime
     * @return
     */
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

    /**
     * 查询resource目录下的json数据
     * @return
     */
    @Override
    public List<TmMtmyProvince> queryAllArea() {
        List<TmMtmyProvince> maps = null;
        try {
            File file = ResourceUtils.getFile("classpath:city.json");
            String s = FileUtils.readFileToString(file, "UTF-8");
            maps = JSON.parseArray(s, TmMtmyProvince.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }

    /**
     * 查询所有的商家
     * @return
     */
    @Override
    public List<Business> queryAllBusiness() {
        return homePageMapper.queryAllBusiness();
    }

    /**
     * 查询附近店铺
     * @param nearShopsDTO
     * @return
     */
    @Override
    public List<NearShopsVo> nearShops(NearShopsDTO nearShopsDTO) {
        List<NearShopsVo> list = new ArrayList<>();
        // 如果用户传入了经纬度
        if (StringUtils.isNoneBlank(nearShopsDTO.getLatitude()) && StringUtils.isNoneBlank(nearShopsDTO.getLongitude())){
            // 根据经纬度得到该地区的省市名
            String s = ConvertLatLngIntoRegion.inverseGeocoding(nearShopsDTO.getLongitude(),nearShopsDTO.getLatitude());
            String[] split = s.split(",");
            String provinceName = split[0];
            String cityName = split[1];
            // 查到所有的省市地区
            List<TmMtmyProvince> tmMtmyProvinces = queryAllArea();
            // 遍历，查到要找的城市ID
            tmMtmyProvinces.forEach(a->{
                if (a.getProvinceName().equals(provinceName)){
                    a.getCities().forEach(b->{
                        if (b.getCityName().equals(cityName)){
                            nearShopsDTO.setCityId(Long.parseLong(b.getCityCode()));
                        }
                    });
                }
            });
            // 通过城市ID查询店铺
            list = homePageMapper.queryShopsByCityId(nearShopsDTO.getCityId());
        }else {
            list = homePageMapper.queryShopsByCityId(nearShopsDTO.getCityId());
        }
        // 根据条件将店铺排序
        // 智能排序
        if (nearShopsDTO.getQueryFlag() == 0){

        }
        // 离我最近
        if (nearShopsDTO.getQueryFlag() == 1){
            list.forEach(a->{
                // 获得店铺离用户的距离
                double v = CalculateDistanceUtil.GetDistance(Double.parseDouble(nearShopsDTO.getLongitude()), Double.parseDouble(nearShopsDTO.getLatitude()), Double.parseDouble(a.getLongitude()), Double.parseDouble(a.getLatitude()));
                // 给距离赋值
                a.setDistance(v);
            });
            //排序
            list = list.stream()
                    .sorted(Comparator.comparing(NearShopsVo::getDistance))
                    .collect(Collectors.toList());
        }
        // 评分最高
        if (nearShopsDTO.getQueryFlag() == 2){
            list = list.stream()
                    .sorted(Comparator.comparing(NearShopsVo::getStarLevel).reversed())
                    .collect(Collectors.toList());
        }
        // 最受欢迎
        if (nearShopsDTO.getQueryFlag() == 3){
            list = list.stream()
                    .sorted(Comparator.comparing(NearShopsVo::getEvaluateCount).reversed())
                    .collect(Collectors.toList());
        }
        return list;
    }
}
