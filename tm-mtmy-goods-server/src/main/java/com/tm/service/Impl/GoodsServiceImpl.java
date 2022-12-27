package com.tm.service.Impl;

import com.tm.entity.vo.GoodsVo;
import com.tm.mapper.GoodsMapper;
import com.tm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @Override
    public List<GoodsVo> goodsItem(Long goodsId) {
        return goodsMapper.goodsItem(goodsId);
    }
}
