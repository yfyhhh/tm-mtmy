package com.tm.entity;


public class UserSkinDimensionRecord {

  private Long id;
  private Long skinId;
  private Integer dimensionId;
  private Integer dimensionSkinGrade;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSkinId() {
    return skinId;
  }

  public void setSkinId(Long skinId) {
    this.skinId = skinId;
  }

  public Integer getDimensionId() {
    return dimensionId;
  }

  public void setDimensionId(Integer dimensionId) {
    this.dimensionId = dimensionId;
  }

  public Integer getDimensionSkinGrade() {
    return dimensionSkinGrade;
  }

  public void setDimensionSkinGrade(Integer dimensionSkinGrade) {
    this.dimensionSkinGrade = dimensionSkinGrade;
  }
}
