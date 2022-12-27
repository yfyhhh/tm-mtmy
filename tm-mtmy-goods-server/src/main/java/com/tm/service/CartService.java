package com.tm.service;

import com.tm.entity.dto.AddCartDTO;
import com.tm.result.Result;

import java.util.List;

public interface CartService {
    Result addCart(AddCartDTO addCartDTO);

    Result queryCartByUserId(Long userId);
}
