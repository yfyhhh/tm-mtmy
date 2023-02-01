package com.tm.entity;

import com.tm.entity.dimension.*;

public class SkinMeasuringRecord {

    private Long skinId;
    private Long beauticianId;
    private Long memberId;
    private String surfaceImg;
    private String bottomImg;
    private String urImg;
    private Integer skinColor;
    private String memberPhone;

    private Moist moist;
    private Cleanliness cleanliness;
    private Sensitivity sensitivity;
    private Sunscreen sunscreen;
    private Smoothness smoothness;
    private Compactness compactness;
    private Blackhead blackhead;
    private HiddenSpot hiddenSpot;

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Long getSkinId() {
        return skinId;
    }

    public void setSkinId(Long skinId) {
        this.skinId = skinId;
    }

    public Long getBeauticianId() {
        return beauticianId;
    }

    public void setBeauticianId(Long beauticianId) {
        this.beauticianId = beauticianId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getSurfaceImg() {
        return surfaceImg;
    }

    public void setSurfaceImg(String surfaceImg) {
        this.surfaceImg = surfaceImg;
    }

    public String getBottomImg() {
        return bottomImg;
    }

    public void setBottomImg(String bottomImg) {
        this.bottomImg = bottomImg;
    }

    public String getUrImg() {
        return urImg;
    }

    public void setUrImg(String urImg) {
        this.urImg = urImg;
    }

    public Integer getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(Integer skinColor) {
        this.skinColor = skinColor;
    }

    public Moist getMoist() {
        return moist;
    }

    public void setMoist(Moist moist) {
        this.moist = moist;
    }

    public Cleanliness getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(Cleanliness cleanliness) {
        this.cleanliness = cleanliness;
    }

    public Sensitivity getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(Sensitivity sensitivity) {
        this.sensitivity = sensitivity;
    }

    public Sunscreen getSunscreen() {
        return sunscreen;
    }

    public void setSunscreen(Sunscreen sunscreen) {
        this.sunscreen = sunscreen;
    }

    public Smoothness getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(Smoothness smoothness) {
        this.smoothness = smoothness;
    }

    public Compactness getCompactness() {
        return compactness;
    }

    public void setCompactness(Compactness compactness) {
        this.compactness = compactness;
    }

    public Blackhead getBlackhead() {
        return blackhead;
    }

    public void setBlackhead(Blackhead blackhead) {
        this.blackhead = blackhead;
    }

    public HiddenSpot getHiddenSpot() {
        return hiddenSpot;
    }

    public void setHiddenSpot(HiddenSpot hiddenSpot) {
        this.hiddenSpot = hiddenSpot;
    }
}
