package com.tm.entity;


public class SkinmiRecord {

  private Long skinId;
  private String surfaceSkinState;
  private String bottomSkinState;
  private String ultravioletSkinState;
  private Integer skinColorGrade;

  public Long getSkinId() {
    return skinId;
  }

  public void setSkinId(Long skinId) {
    this.skinId = skinId;
  }

  public String getSurfaceSkinState() {
    return surfaceSkinState;
  }

  public void setSurfaceSkinState(String surfaceSkinState) {
    this.surfaceSkinState = surfaceSkinState;
  }

  public String getBottomSkinState() {
    return bottomSkinState;
  }

  public void setBottomSkinState(String bottomSkinState) {
    this.bottomSkinState = bottomSkinState;
  }

  public String getUltravioletSkinState() {
    return ultravioletSkinState;
  }

  public void setUltravioletSkinState(String ultravioletSkinState) {
    this.ultravioletSkinState = ultravioletSkinState;
  }

  public Integer getSkinColorGrade() {
    return skinColorGrade;
  }

  public void setSkinColorGrade(Integer skinColorGrade) {
    this.skinColorGrade = skinColorGrade;
  }
}
