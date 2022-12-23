package com.tm.entity;


import java.math.BigDecimal;

public class CartGoods {

  private Long userId;
  private Long sgmId;
  private Integer goodsCount;
  private BigDecimal totalPrice;
  private Long createTime;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getSgmId() {
    return sgmId;
  }

  public void setSgmId(Long sgmId) {
    this.sgmId = sgmId;
  }

  public Integer getGoodsCount() {
    return goodsCount;
  }

  public void setGoodsCount(Integer goodsCount) {
    this.goodsCount = goodsCount;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }
}
