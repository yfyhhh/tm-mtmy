package com.tm.entity;


public class HealthGuidelines {

  private Integer id;
  private Integer minStomachMeridian;
  private Integer maxStomachMeridian;
  private String dietaryTaboos;
  private String mattersNeedingAttention;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMinStomachMeridian() {
    return minStomachMeridian;
  }

  public void setMinStomachMeridian(Integer minStomachMeridian) {
    this.minStomachMeridian = minStomachMeridian;
  }

  public Integer getMaxStomachMeridian() {
    return maxStomachMeridian;
  }

  public void setMaxStomachMeridian(Integer maxStomachMeridian) {
    this.maxStomachMeridian = maxStomachMeridian;
  }

  public String getDietaryTaboos() {
    return dietaryTaboos;
  }

  public void setDietaryTaboos(String dietaryTaboos) {
    this.dietaryTaboos = dietaryTaboos;
  }

  public String getMattersNeedingAttention() {
    return mattersNeedingAttention;
  }

  public void setMattersNeedingAttention(String mattersNeedingAttention) {
    this.mattersNeedingAttention = mattersNeedingAttention;
  }
}
