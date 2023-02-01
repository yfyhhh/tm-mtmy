package com.tm.mapper;

import com.tm.entity.SkinMeasuringRecord;
import com.tm.entity.bo.DimensionBo;
import com.tm.entity.vo.SkinRecordVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SkinMeasuringMapper{

    Long addSkinmiRecord(SkinMeasuringRecord record);

    @Select("select user_phone from t_user where user_id = #{memberId}")
    String queryPhoneById(Long memberId);

    @Select("select " +
                "dimension_id, " +
                "dimension_name " +
            "from " +
                "t_dimension_mapping")
    List<DimensionBo> queryAllDimension();

    void addUserSkinDimensionRecord(@Param("skinId") Long skinId, @Param("mapList")List<Map<String, String>> mapList);

    @Select("")
    List<SkinRecordVo> allBeauticianSkinRecord(Long beauticianId);
}
