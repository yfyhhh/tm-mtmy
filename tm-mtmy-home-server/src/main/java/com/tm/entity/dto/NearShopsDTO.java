package com.tm.entity.dto;

public class NearShopsDTO {

    private Long businessId;
    private Long provinceId;
    private Long cityId;
    private Long countyId;
    private String longitude;
    private String latitude;
    private Integer queryFlag; // 0 智能排序；1 离我最近；2 评分最高；3 最受欢迎

    public Integer getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(Integer queryFlag) {
        this.queryFlag = queryFlag;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
