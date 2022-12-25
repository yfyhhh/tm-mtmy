package com.tm.entity;

import java.util.List;

public class TmMtmyCity {
    private String cityCode;
    private String cityName;
    private Integer cityType;
    private Boolean isCapital;
    private List<TmMtmyCounty> counties;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityType() {
        return cityType;
    }

    public void setCityType(Integer cityType) {
        this.cityType = cityType;
    }

    public Boolean getCapital() {
        return isCapital;
    }

    public void setCapital(Boolean capital) {
        isCapital = capital;
    }

    public List<TmMtmyCounty> getCounties() {
        return counties;
    }

    public void setCounties(List<TmMtmyCounty> counties) {
        this.counties = counties;
    }
}
