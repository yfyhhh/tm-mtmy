package com.tm.entity.vo;

import java.util.List;

public class GoodsVo {

    private Long goodsId;
    private String goodsBanner;
    private String goodsName;
    private Integer goodsBy;
    private Integer goodsBusinessId;
    private String goodsIntroduce;
    private Integer typeName;
    private List<SpecsGoodsVo> specs;

    public List<SpecsGoodsVo> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecsGoodsVo> specs) {
        this.specs = specs;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsBanner() {
        return goodsBanner;
    }

    public void setGoodsBanner(String goodsBanner) {
        this.goodsBanner = goodsBanner;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsBy() {
        return goodsBy;
    }

    public void setGoodsBy(Integer goodsBy) {
        this.goodsBy = goodsBy;
    }

    public Integer getGoodsBusinessId() {
        return goodsBusinessId;
    }

    public void setGoodsBusinessId(Integer goodsBusinessId) {
        this.goodsBusinessId = goodsBusinessId;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public Integer getTypeName() {
        return typeName;
    }

    public void setTypeName(Integer typeName) {
        this.typeName = typeName;
    }
}
