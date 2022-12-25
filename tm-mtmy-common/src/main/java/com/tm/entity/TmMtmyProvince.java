package com.tm.entity;

import java.util.List;

public class TmMtmyProvince {
    private String provinceCode;
    private String provinceName;
    private String provinceType;
    private List<TmMtmyCity> cities;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceType() {
        return provinceType;
    }

    public void setProvinceType(String provinceType) {
        this.provinceType = provinceType;
    }

    public List<TmMtmyCity> getCities() {
        return cities;
    }

    public void setCities(List<TmMtmyCity> cities) {
        this.cities = cities;
    }
}
