package com.tm.entity;


public class Text {

  private Long textId;
  private String textContent;
  private String imgOne;
  private String imgTwo;
  private String imgThree;
  private Long textAuthorId;
  private Integer visitCount;
  private Integer thumbsUpCount;
  private Integer textType;
  private Long createTime;
  private Long updateTime;

  public Long getTextId() {
    return textId;
  }

  public void setTextId(Long textId) {
    this.textId = textId;
  }

  public String getTextContent() {
    return textContent;
  }

  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }

  public String getImgOne() {
    return imgOne;
  }

  public void setImgOne(String imgOne) {
    this.imgOne = imgOne;
  }

  public String getImgTwo() {
    return imgTwo;
  }

  public void setImgTwo(String imgTwo) {
    this.imgTwo = imgTwo;
  }

  public String getImgThree() {
    return imgThree;
  }

  public void setImgThree(String imgThree) {
    this.imgThree = imgThree;
  }

  public Long getTextAuthorId() {
    return textAuthorId;
  }

  public void setTextAuthorId(Long textAuthorId) {
    this.textAuthorId = textAuthorId;
  }

  public Integer getVisitCount() {
    return visitCount;
  }

  public void setVisitCount(Integer visitCount) {
    this.visitCount = visitCount;
  }

  public Integer getThumbsUpCount() {
    return thumbsUpCount;
  }

  public void setThumbsUpCount(Integer thumbsUpCount) {
    this.thumbsUpCount = thumbsUpCount;
  }

  public Integer getTextType() {
    return textType;
  }

  public void setTextType(Integer textType) {
    this.textType = textType;
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
