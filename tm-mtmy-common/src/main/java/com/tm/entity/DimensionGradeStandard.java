package com.tm.entity;


public class DimensionGradeStandard {

  private Integer id;
  private Integer dimensionId;
  private Integer minGrade;
  private Integer maxGrade;
  private String evaluate;
  private String carePlan;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDimensionId() {
    return dimensionId;
  }

  public void setDimensionId(Integer dimensionId) {
    this.dimensionId = dimensionId;
  }

  public Integer getMinGrade() {
    return minGrade;
  }

  public void setMinGrade(Integer minGrade) {
    this.minGrade = minGrade;
  }

  public Integer getMaxGrade() {
    return maxGrade;
  }

  public void setMaxGrade(Integer maxGrade) {
    this.maxGrade = maxGrade;
  }

  public String getEvaluate() {
    return evaluate;
  }

  public void setEvaluate(String evaluate) {
    this.evaluate = evaluate;
  }

  public String getCarePlan() {
    return carePlan;
  }

  public void setCarePlan(String carePlan) {
    this.carePlan = carePlan;
  }
}
