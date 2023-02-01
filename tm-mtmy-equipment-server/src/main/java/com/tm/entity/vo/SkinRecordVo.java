package com.tm.entity.vo;

public class SkinRecordVo {
    private Long skinId;
    private String phoneNumber;
    private String recordTime;
    private String dimensionNameChinese;
    private Integer dimensionSkinGrade;


    public Long getSkinId() {
        return skinId;
    }

    public void setSkinId(Long skinId) {
        this.skinId = skinId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getDimensionNameChinese() {
        return dimensionNameChinese;
    }

    public void setDimensionNameChinese(String dimensionNameChinese) {
        this.dimensionNameChinese = dimensionNameChinese;
    }

    public Integer getDimensionSkinGrade() {
        return dimensionSkinGrade;
    }

    public void setDimensionSkinGrade(Integer dimensionSkinGrade) {
        this.dimensionSkinGrade = dimensionSkinGrade;
    }
}
