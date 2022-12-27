package com.tm.controller;

import com.tm.entity.dto.AddCartDTO;
import com.tm.result.Result;
import com.tm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加购物车
     * @param addCartDTO
     * @return
     */
    @PostMapping("addCart")
    public Result addCart(AddCartDTO addCartDTO){
        return cartService.addCart(addCartDTO);
    }

    /**
     * 查询购物车
     * @param userId
     * @return
     */
    @PostMapping("queryCartByUserId")
    public Result queryCartByUserId(Long userId){
        return cartService.queryCartByUserId(userId);
    }

}
