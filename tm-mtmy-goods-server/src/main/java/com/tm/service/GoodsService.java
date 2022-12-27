package com.tm.service;

import com.tm.entity.vo.GoodsVo;

import java.util.List;

public interface GoodsService {
    List<GoodsVo> goodsItem(Long goodsId);
}
