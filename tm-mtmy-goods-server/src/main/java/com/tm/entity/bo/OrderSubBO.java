package com.tm.entity.bo;

import java.math.BigDecimal;

public class OrderSubBO {

    private Long id;
    private Long ordersId;
    private Long goodsId;
    // 成交价格
    private BigDecimal buyDealPrice;
    // 原价
    private BigDecimal buyCostPrice;
    private String goodsDealName;
    private Long sgmId;
    private Integer count;
    // 订单状态0未发货 1在路上 2已签收 3已退货 4已评价
    private Integer ordersGoodsType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getBuyDealPrice() {
        return buyDealPrice;
    }

    public void setBuyDealPrice(BigDecimal buyDealPrice) {
        this.buyDealPrice = buyDealPrice;
    }

    public BigDecimal getBuyCostPrice() {
        return buyCostPrice;
    }

    public void setBuyCostPrice(BigDecimal buyCostPrice) {
        this.buyCostPrice = buyCostPrice;
    }

    public String getGoodsDealName() {
        return goodsDealName;
    }

    public void setGoodsDealName(String goodsDealName) {
        this.goodsDealName = goodsDealName;
    }

    public Long getSgmId() {
        return sgmId;
    }

    public void setSgmId(Long sgmId) {
        this.sgmId = sgmId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Integer getOrdersGoodsType() {
        return ordersGoodsType;
    }

    public void setOrdersGoodsType(Integer ordersGoodsType) {
        this.ordersGoodsType = ordersGoodsType;
    }
}
