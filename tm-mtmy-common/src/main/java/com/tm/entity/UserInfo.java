package com.tm.entity;


public class UserInfo {

  private Long userId;
  private String userImg;
  private Integer userLevel;
  private String userLevelTitle;
  private Integer beautifulGrade;
  private Integer userJob;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserImg() {
    return userImg;
  }

  public void setUserImg(String userImg) {
    this.userImg = userImg;
  }

  public Integer getUserLevel() {
    return userLevel;
  }

  public void setUserLevel(Integer userLevel) {
    this.userLevel = userLevel;
  }

  public String getUserLevelTitle() {
    return userLevelTitle;
  }

  public void setUserLevelTitle(String userLevelTitle) {
    this.userLevelTitle = userLevelTitle;
  }

  public Integer getBeautifulGrade() {
    return beautifulGrade;
  }

  public void setBeautifulGrade(Integer beautifulGrade) {
    this.beautifulGrade = beautifulGrade;
  }

  public Integer getUserJob() {
    return userJob;
  }

  public void setUserJob(Integer userJob) {
    this.userJob = userJob;
  }
}
