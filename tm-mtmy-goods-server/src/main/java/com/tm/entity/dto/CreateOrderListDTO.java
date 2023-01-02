package com.tm.entity.dto;

public class CreateOrderListDTO {

    private Long goodsId;
    private Long specsId;
    private Integer count;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSpecsId() {
        return specsId;
    }

    public void setSpecsId(Long specsId) {
        this.specsId = specsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
