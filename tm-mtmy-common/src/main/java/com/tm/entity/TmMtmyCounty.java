package com.tm.entity;

public class TmMtmyCounty {
    private String countyCode;
    private String countyName;
    private Boolean isCity;

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Boolean getCity() {
        return isCity;
    }

    public void setCity(Boolean city) {
        isCity = city;
    }
}
