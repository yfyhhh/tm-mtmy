package com.tm.entity;


public class UserSave {

  private Long saveId;
  //收藏类型 (0文章  1商品  2视频  3活动)
  private Integer saveType;
  private Long userContentId;
  private Long userId;
  private Long createTime;
  private Long updateTime;


  public Long getSaveId() {
    return saveId;
  }

  public void setSaveId(Long saveId) {
    this.saveId = saveId;
  }

  public Integer getSaveType() {
    return saveType;
  }

  public void setSaveType(Integer saveType) {
    this.saveType = saveType;
  }

  public Long getUserContentId() {
    return userContentId;
  }

  public void setUserContentId(Long userContentId) {
    this.userContentId = userContentId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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
