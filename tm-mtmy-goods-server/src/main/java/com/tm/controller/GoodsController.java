package com.tm.controller;

import com.tm.result.Result;
import com.tm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @PostMapping("goodsItem")
    public Result goodsItem(Long goodsId){
        return Result.SUCCESS(goodsService.goodsItem(goodsId));
    }

}
