package com.tm.entity;


import java.math.BigDecimal;

public class SpecsGoodsMapping {

  private Long sgmId;
  private Long specsId;
  private BigDecimal goodsSgmPrice;
  private Long salesVolumeNum;
  private Integer goodsStock;
  private Integer goodsIsUp;
  private Long createTime;
  private Long updateTime;

  public Long getSgmId() {
    return sgmId;
  }

  public void setSgmId(Long sgmId) {
    this.sgmId = sgmId;
  }

  public Long getSpecsId() {
    return specsId;
  }

  public void setSpecsId(Long specsId) {
    this.specsId = specsId;
  }

  public BigDecimal getGoodsSgmPrice() {
    return goodsSgmPrice;
  }

  public void setGoodsSgmPrice(BigDecimal goodsSgmPrice) {
    this.goodsSgmPrice = goodsSgmPrice;
  }

  public Long getSalesVolumeNum() {
    return salesVolumeNum;
  }

  public void setSalesVolumeNum(Long salesVolumeNum) {
    this.salesVolumeNum = salesVolumeNum;
  }

  public Integer getGoodsStock() {
    return goodsStock;
  }

  public void setGoodsStock(Integer goodsStock) {
    this.goodsStock = goodsStock;
  }

  public Integer getGoodsIsUp() {
    return goodsIsUp;
  }

  public void setGoodsIsUp(Integer goodsIsUp) {
    this.goodsIsUp = goodsIsUp;
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
