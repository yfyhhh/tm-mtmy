package com.tm.entity.bo;

import java.math.BigDecimal;

public class SpecsGoodsBO {

    private Long sgmId;
    private Long specsId;
    private BigDecimal goodsSgmPrice;
    private Long salesVolumeNum;
    private Integer goodsStock;

    public Long getSgmId() {
        return sgmId;
    }

    public void setSgmId(Long sgmId) {
        this.sgmId = sgmId;
    }

    public Long getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Long specsId) {
        this.specsId = specsId;
    }

    public BigDecimal getGoodsSgmPrice() {
        return goodsSgmPrice;
    }

    public void setGoodsSgmPrice(BigDecimal goodsSgmPrice) {
        this.goodsSgmPrice = goodsSgmPrice;
    }

    public Long getSalesVolumeNum() {
        return salesVolumeNum;
    }

    public void setSalesVolumeNum(Long salesVolumeNum) {
        this.salesVolumeNum = salesVolumeNum;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }
}
