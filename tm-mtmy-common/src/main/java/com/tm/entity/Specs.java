package com.tm.entity;


public class Specs {

  private Long specsId;
  //规格名(0单品1套装2拆套装五盒)
  private Integer specsName;
  private Long updateDate;
  private Long createTime;

  public Long getSpecsId() {
    return specsId;
  }

  public void setSpecsId(Long specsId) {
    this.specsId = specsId;
  }

  public Integer getSpecsName() {
    return specsName;
  }

  public void setSpecsName(Integer specsName) {
    this.specsName = specsName;
  }

  public Long getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Long updateDate) {
    this.updateDate = updateDate;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }
}
