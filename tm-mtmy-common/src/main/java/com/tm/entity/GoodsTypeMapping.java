package com.tm.entity;


public class GoodsTypeMapping {

  private Long gtmId;
  private Long typeId;
  private Long goodsId;
  private Long createTime;
  private Long updateTime;

  public Long getGtmId() {
    return gtmId;
  }

  public void setGtmId(Long gtmId) {
    this.gtmId = gtmId;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public Long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }
}
