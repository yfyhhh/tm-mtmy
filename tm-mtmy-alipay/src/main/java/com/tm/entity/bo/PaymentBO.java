package com.tm.entity.bo;
 
import lombok.Data;
 
import java.math.BigDecimal;
 
/**
 *  发起支付时的参数
 * */
public class PaymentBO {
    //省略其他的业务参数，如商品id、购买数量等

    private Long ordersId;
    //商品名称
    private String subject;
 
    //总金额
    private BigDecimal total = BigDecimal.ZERO;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Long ordersId) {
        this.ordersId = ordersId;
    }
}