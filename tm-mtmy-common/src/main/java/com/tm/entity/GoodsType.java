package com.tm.entity;


public class GoodsType {

  private Long typeId;
  //类型名称(0抗皱淡纹1补水保湿2防晒3祛斑4美白)
  private Integer typeName;
  private Long createTime;
  private Long updateTime;

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public Integer getTypeName() {
    return typeName;
  }

  public void setTypeName(Integer typeName) {
    this.typeName = typeName;
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
