package com.tm.entity.vo;

public class UserAddrVo {

    private Long addressId;
    private Long userId;
    private Integer provinceId;
    private String provinceName;
    private Integer cityId;
    private String cityName;
    private Integer areaId;
    private String areaName;
    private String detailedAddress;
    private String consigneeName;
    private Integer consigneeSex;
    private String ConsigneePhone;
    private String fixedPhoneNumber;
    private String emailAddress;
    private String addrByName;
    private Integer isEnable;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public Integer getConsigneeSex() {
        return consigneeSex;
    }

    public void setConsigneeSex(Integer consigneeSex) {
        this.consigneeSex = consigneeSex;
    }

    public String getConsigneePhone() {
        return ConsigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        ConsigneePhone = consigneePhone;
    }

    public String getFixedPhoneNumber() {
        return fixedPhoneNumber;
    }

    public void setFixedPhoneNumber(String fixedPhoneNumber) {
        this.fixedPhoneNumber = fixedPhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddrByName() {
        return addrByName;
    }

    public void setAddrByName(String addrByName) {
        this.addrByName = addrByName;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}
