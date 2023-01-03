package com.tm.mapper;

import com.tm.entity.OrdersPayInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PaySuccessMapper {

    @Insert("insert into " +
                "t_orders_pay_info (" +
                "orders_id, " +
                "trade_no, " +
                "seller_id, " +
                "timestamp, " +
                "total_amount " +
                ") values (" +
                "#{out_trade_no}, " +
                "#{trade_no}, " +
                "#{seller_id}, " +
                "#{timestamp}, " +
                "#{total_amount}" +
                ")")
    Integer addOrdersPayInfo(OrdersPayInfo payInfo);

    @Update("update t_orders set orders_type = 1 where orders_id = #{ordersId}")
    void updateOrdersTypeById(String ordersId);
}
