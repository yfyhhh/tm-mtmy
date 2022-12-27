package com.tm.entity.bo;

public class GoodsBO {

    private Long goodsId;
    private String goodsBanner;
    private String goodsName;
    private Integer goodsBy;
    private String goodsIntroduce;
    private Integer typeName;
    private SpecsGoodsBO goodsBO;

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

    public SpecsGoodsBO getGoodsBO() {
        return goodsBO;
    }

    public void setGoodsBO(SpecsGoodsBO goodsBO) {
        this.goodsBO = goodsBO;
    }
}
