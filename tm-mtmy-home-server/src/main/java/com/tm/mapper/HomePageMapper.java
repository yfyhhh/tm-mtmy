package com.tm.mapper;

import com.tm.entity.Business;
import com.tm.entity.Video;
import com.tm.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomePageMapper {

    @Select("select " +
                "sa_id as saId, " +
                "sa_business_id as saBusinessId, " +
                "sa_image as saImage, " +
                "goods_id as goodsId " +
            "from " +
                "t_selected_activities " +
            "where " +
                "start_time < unix_timestamp(now()) " +
              "and " +
                "end_time > unix_timestamp(now()) ")
    List<SelectedActivitiesVo> selectedActivities();

    @Select("select " +
                "tdr.id, " +
                "tdr.goods_id as goodsId, " +
                "tg.goods_banner as goodsBanner " +
            "from " +
                "t_daily_required as tdr " +
              "right join " +
                "t_goods as tg " +
              "on " +
                "tdr.goods_id = tg.goods_id " +
            "where " +
                "tdr.min_age <= #{userAge} " +
              "and " +
                "tdr.max_age > #{userAge} " +
              "and " +
                "tg.goods_is_up = 0 ")
    List<DailyRequiredVo> dailyRequired(Integer userAge);

    @Select("select " +
                "video_id as videoId, " +
                "video_author_id as videoAuthorId, " +
                "video_url as videoUrl, " +
                "video_count as videoCount, " +
                "thumbs_up_count as thumbsUpCount, " +
                "user_name as userName " +
            "from t_video as tv " +
            "left join t_user as tu " +
            "on tv.video_author_id = tu.user_id " +
            "where " +
                "video_type = 0 " +
            "limit #{param1}, #{param2}")
    List<VideoVo> homeVideo(Integer startIndex, Integer pageSize);

    @Select("select " +
                "g.goods_id as goodsId, " +
                "g.goods_banner as goodsBanner, " +
                "g.goods_name as goodsName, " +
                "sgm.goods_sgm_price as goodsSgmPrice, " +
                "g.goods_text as goodsText " +
            "from " +
                "t_goods as g " +
            "left join " +
                "t_specs_goods_mapping sgm " +
            "on " +
                "g.goods_id = sgm.goods_id " +
            "left join " +
                "t_specs as s " +
            "on " +
                "sgm.specs_id = s.specs_id " +
            "where " +
                "(select count(1) from t_goods where goods_business_id = g.goods_business_id and goods_id > g.goods_id) < 3 " +
            "and " +
                "g.goods_is_up = 0 " +
            "and " +
                "sgm.goods_is_up = 0 " +
            "group by g.goods_id")
    List<HaveNiceGoodsVo> haveNiceGoods();

    @Select("select " +
                "t.text_id as textId, " +
                "t.text_title as textTitle, " +
                "t.img_one as imgOneUrl, " +
                "t.img_two as imgTwoUrl, " +
                "t.img_three as imgThreeUrl, " +
                "t.text_author_id as textAuthorId, " +
                "ui.user_img as userImg, " +
                "ui.user_job as userJobId, " +
                "t.text_type as textTypeId, " +
                "t.visit_count as visitCount " +
            "from " +
                "t_text as t " +
            "left join " +
                "t_user as u " +
            "on " +
                "t.text_author_id = u.user_id " +
            "left join " +
                "t_user_info as ui " +
            "on " +
                "ui.user_id = u.user_id " +
            "where " +
                "t.create_time >= #{param1} " +
            "and " +
                "t.create_time < #{param2} " +
            "order by t.create_time desc ")
    List<BeautifulSchoolVo> BeautifulSchoolNoLogin(Long dateTime, Long endTime);

    @Select("select " +
                "t.text_id as textId, " +
                "t.text_title as textTitle, " +
                "t.img_one as imgOneUrl, " +
                "t.img_two as imgTwoUrl, " +
                "t.img_three as imgThreeUrl, " +
                "t.text_author_id as textAuthorId, " +
                "ui.user_img as userImg, " +
                "ui.user_job as userJobId, " +
                "t.text_type as textTypeId, " +
                "t.visit_count as visitCount " +
            "from " +
                "t_text as t " +
            "left join " +
                "t_user as u " +
            "on " +
                "t.text_author_id = u.user_id " +
            "left join " +
                "t_user_info as ui " +
            "on " +
                "ui.user_id = u.user_id " +
            "left join " +
                "t_user_follow as uf " +
            "on " +
                "uf.follow_user_id = t.text_author_id " +
            "where " +
                "t.create_time >= #{param2} " +
            "and " +
                "t.create_time < #{param3} " +
            "and " +
                "uf.user_id = #{param1} " +
            "order by t.create_time desc ")
    List<BeautifulSchoolVo> BeautifulSchoolByUserId(Long userId, Long dateTime, long endTime);

    @Select("select " +
                "t.text_id as textId, " +
                "t.text_title as textTitle, " +
                "t.img_one as imgOneUrl, " +
                "t.img_two as imgTwoUrl, " +
                "t.img_three as imgThreeUrl, " +
                "t.text_author_id as textAuthorId, " +
                "ui.user_img as userImg, " +
                "ui.user_job as userJobId, " +
                "t.text_type as textTypeId, " +
                "t.visit_count as visitCount " +
            "from " +
                "t_text as t " +
            "left join " +
                "t_user as u " +
            "on " +
                "t.text_author_id = u.user_id " +
            "left join " +
                "t_user_info as ui " +
            "on " +
                "ui.user_id = u.user_id " +
            "left join " +
                "t_user_follow as uf " +
            "on " +
                "uf.follow_user_id = t.text_author_id " +
            "where " +
                "t.create_time >= #{param2} " +
            "and " +
                "t.create_time < #{param3} " +
            "and " +
                "uf.user_id != #{param1} " +
            "order by t.create_time desc ")
    List<BeautifulSchoolVo> BeautifulSchoolUnByUserId(Long userId, Long dateTime, long l);

    @Select("select " +
                "business_id as businessId, " +
                "business_name as businessName, " +
                "business_user_id as businessUserId " +
            "from " +
                "t_business ")
    List<Business> queryAllBusiness();

    @Select("SELECT " +
                "s.*, " +
                "(SELECT avg(se.star_level) from t_shop_evaluate as se where se.shop_id = s.shop_id) as starLevel, " +
                "(SELECT count(1) from t_shop_evaluate as se where se.shop_id = s.shop_id) as evaluateCount " +
            "FROM " +
                "t_shop as s " +
            "where " +
                "city_id = 440100")
    List<NearShopsVo> queryShopsByCityId(Long cityId);
}
