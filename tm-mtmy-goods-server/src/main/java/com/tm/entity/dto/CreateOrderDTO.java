package com.tm.entity.dto;

import java.util.List;

public class CreateOrderDTO {

    private Long userId;
    private String orderFlag;
    private List<CreateOrderListDTO> createOrderListDTOS;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public List<CreateOrderListDTO> getCreateOrderListDTOS() {
        return createOrderListDTOS;
    }

    public void setCreateOrderListDTOS(List<CreateOrderListDTO> createOrderListDTOS) {
        this.createOrderListDTOS = createOrderListDTOS;
    }
}
