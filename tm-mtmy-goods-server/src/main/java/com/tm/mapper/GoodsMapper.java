package com.tm.mapper;

import com.tm.entity.bo.GoodsBO;
import com.tm.entity.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsVo> goodsItem(Long goodsId);


    GoodsBO goodsInfoBySpecId(Long goodsId, Long specId);
}
