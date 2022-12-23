package com.tm.entity;


public class SelectedActivities {

  private Long saId;
  private Long saBusinessId;
  private String saImage;
  private Long goodsId;
  private Long startTime;
  private Long endTime;

  public Long getSaId() {
    return saId;
  }

  public void setSaId(Long saId) {
    this.saId = saId;
  }

  public Long getSaBusinessId() {
    return saBusinessId;
  }

  public void setSaBusinessId(Long saBusinessId) {
    this.saBusinessId = saBusinessId;
  }

  public String getSaImage() {
    return saImage;
  }

  public void setSaImage(String saImage) {
    this.saImage = saImage;
  }

  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public Long getStartTime() {
    return startTime;
  }

  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  public Long getEndTime() {
    return endTime;
  }

  public void setEndTime(Long endTime) {
    this.endTime = endTime;
  }
}
