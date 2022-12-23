package com.tm.entity;


public class User {

  private Long userId;
  private String userPwd;
  private Integer userAge;
  private String userName;
  private String realName;
  private String userIdCardNum;
  private Integer userSex;
  private String userPhone;
  private Long beauticianUserId;
  private Integer role;
  private Long businessId;


  public User() {
  }

  public User(Long userId, String userPwd, Integer userAge, String userName, String realName, String userIdCardNum, Integer userSex, String userPhone, Long beauticianUserId, Integer role, Long businessId) {
    this.userId = userId;
    this.userPwd = userPwd;
    this.userAge = userAge;
    this.userName = userName;
    this.realName = realName;
    this.userIdCardNum = userIdCardNum;
    this.userSex = userSex;
    this.userPhone = userPhone;
    this.beauticianUserId = beauticianUserId;
    this.role = role;
    this.businessId = businessId;
  }

  public Long getBeauticianUserId() {
    return beauticianUserId;
  }

  public void setBeauticianUserId(Long beauticianUserId) {
    this.beauticianUserId = beauticianUserId;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public Long getBusinessId() {
    return businessId;
  }

  public void setBusinessId(Long businessId) {
    this.businessId = businessId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getUserIdCardNum() {
    return userIdCardNum;
  }

  public void setUserIdCardNum(String userIdCardNum) {
    this.userIdCardNum = userIdCardNum;
  }

  public Integer getUserSex() {
    return userSex;
  }

  public void setUserSex(Integer userSex) {
    this.userSex = userSex;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public Integer getUserAge() {
    return userAge;
  }

  public void setUserAge(Integer userAge) {
    this.userAge = userAge;
  }
}
