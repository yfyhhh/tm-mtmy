package com.tm.entity;


import java.math.BigDecimal;

public class Orders {

  private Long ordersId;
  private Long userId;
  private BigDecimal ordersTotalPrice;
  private Long ordersCreateTime;
  private Long payTime;
  private Integer ordersType;


  public Long getOrdersId() {
    return ordersId;
  }

  public void setOrdersId(Long ordersId) {
    this.ordersId = ordersId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public BigDecimal getOrdersTotalPrice() {
    return ordersTotalPrice;
  }

  public void setOrdersTotalPrice(BigDecimal ordersTotalPrice) {
    this.ordersTotalPrice = ordersTotalPrice;
  }

  public Long getOrdersCreateTime() {
    return ordersCreateTime;
  }

  public void setOrdersCreateTime(Long ordersCreateTime) {
    this.ordersCreateTime = ordersCreateTime;
  }

  public Long getPayTime() {
    return payTime;
  }

  public void setPayTime(Long payTime) {
    this.payTime = payTime;
  }

  public Integer getOrdersType() {
    return ordersType;
  }

  public void setOrdersType(Integer ordersType) {
    this.ordersType = ordersType;
  }
}
