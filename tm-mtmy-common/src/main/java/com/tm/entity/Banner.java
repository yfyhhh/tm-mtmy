package com.tm.entity;


public class Banner {

  private Long bannerId;
  private Integer bannerType;
  private String bannerImg;
  private Long bannerStartTime;
  private Long bannerEndTime;

  public Long getBannerId() {
    return bannerId;
  }

  public void setBannerId(Long bannerId) {
    this.bannerId = bannerId;
  }

  public Integer getBannerType() {
    return bannerType;
  }

  public void setBannerType(Integer bannerType) {
    this.bannerType = bannerType;
  }

  public String getBannerImg() {
    return bannerImg;
  }

  public void setBannerImg(String bannerImg) {
    this.bannerImg = bannerImg;
  }

  public Long getBannerStartTime() {
    return bannerStartTime;
  }

  public void setBannerStartTime(Long bannerStartTime) {
    this.bannerStartTime = bannerStartTime;
  }

  public Long getBannerEndTime() {
    return bannerEndTime;
  }

  public void setBannerEndTime(Long bannerEndTime) {
    this.bannerEndTime = bannerEndTime;
  }
}
