package com.tm.service;

import com.tm.entity.OrdersPayInfo;
import com.tm.result.Result;

public interface PaySuccessService {
    Result paySuccess(OrdersPayInfo payInfo);
}
