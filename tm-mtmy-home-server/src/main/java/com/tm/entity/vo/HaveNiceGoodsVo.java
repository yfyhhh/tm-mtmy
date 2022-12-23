package com.tm.entity.vo;

import java.math.BigDecimal;

public class HaveNiceGoodsVo {
    private Long goodsId;
    private String goodsBanner;
    private String goodsName;
    private BigDecimal goodsSgmPrice;
    private String goodsText;

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

    public BigDecimal getGoodsSgmPrice() {
        return goodsSgmPrice;
    }

    public void setGoodsSgmPrice(BigDecimal goodsSgmPrice) {
        this.goodsSgmPrice = goodsSgmPrice;
    }

    public String getGoodsText() {
        return goodsText;
    }

    public void setGoodsText(String goodsText) {
        this.goodsText = goodsText;
    }
}
