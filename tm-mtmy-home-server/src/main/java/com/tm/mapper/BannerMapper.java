package com.tm.mapper;

import com.tm.entity.vo.BannerVo;
import com.tm.result.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BannerMapper {

    @Select("select " +
                "banner_id as bannerId, " +
                "banner_type as bannerType, " +
                "banner_img as bannerImg " +
            "from " +
                "t_banner " +
            "where " +
                "banner_start_time < unix_timestamp(now()) " +
              "and " +
                "banner_end_time > unix_timestamp(now()) ")
    BannerVo bannerList();
}
