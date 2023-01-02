package com.tm.service;

import com.tm.entity.UserAddr;
import com.tm.entity.dto.CreateOrderDTO;
import com.tm.result.Result;

public interface OrderService {
    Result addrList(Long userId);

    Result allAddr();

    Result addUserAddr(UserAddr userAddr);

    Result getOrderFlag();

    Result createOrder(CreateOrderDTO createOrderDTO);
}
