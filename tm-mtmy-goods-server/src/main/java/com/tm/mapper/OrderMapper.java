package com.tm.mapper;

import com.tm.entity.UserAddr;
import com.tm.entity.bo.OrderSubBO;
import com.tm.entity.vo.UserAddrVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from t_user_address where user_id = #{userId}")
    List<UserAddrVo> addrList(Long userId);

    @Select("select name from t_address where id = #{id}")
    String queryAddressNameById(Integer id);

    @Insert("insert into t_user_address (" +
                "user_id, " +
                "province_id, " +
                "city_id, " +
                "area_id, " +
                "detailed_address, " +
                "consignee_name, " +
                "consignee_sex, " +
                "Consignee_phone, " +
                "fixed_phone_number, " +
                "email_address, " +
                "addr_by_name, " +
                "is_enable) " +
            "values (" +
                "#{userId}, " +
                "#{provinceId}, " +
                "#{cityId}, " +
                "#{areaId}, " +
                "#{detailedAddress}, " +
                "#{consigneeName}, " +
                "#{consigneeSex}, " +
                "#{ConsigneePhone}, " +
                "#{fixedPhoneNumber}, " +
                "#{emailAddress}, " +
                "#{addrByName}, " +
                "#{isEnable}) ")
    Integer addUserAddr(UserAddr userAddr);

    @Select("select " +
                "sgm.goods_sgm_price as buyCostPrice, " +
                "g.goods_name as goodsDealName " +
            "from " +
                "t_goods as g " +
            "left join " +
                "t_specs_goods_mapping as sgm " +
            "on " +
                "g.goods_id = sgm.goods_id " +
            "where " +
                "g.goods_id = #{param1} " +
            "and " +
                "specs_id = #{param2}")
    OrderSubBO queryGoodsDetailById(Long goodsId, Long specsId);

    @Insert("insert into " +
                "t_orders_sub (" +
                "orders_id, " +
                "goods_id, " +
                "buy_deal_price, " +
                "buy_cost_price, " +
                "goods_deal_name, " +
                "sgm_id, " +
                "count, " +
                "orders_goods_type " +
                ")values (" +
                "#{ordersId}, " +
                "#{goodsId}, " +
                "#{buyDealPrice}, " +
                "#{buyCostPrice}, " +
                "#{goodsDealName}, " +
                "#{sgmId}, " +
                "#{count}, " +
                "#{ordersGoodsType})")
    Integer addOrderSub(OrderSubBO orderSubBO);

    @Insert("insert into " +
                "t_orders (" +
                "orders_id, " +
                "user_id, " +
                "orders_create_time, " +
                "orders_type " +
                ")values (" +
                "#{param2}, " +
                "#{param1}, " +
                "unix_timestamp(now()), " +
                "0)")
    void addOrder(Long userId, String orderId);

    @Update("update t_orders set orders_total_price = #{param2} where orders_id = #{param1}")
    void insertOrderPrice(String orderId, BigDecimal bigDecimal);

    @Update("update " +
                "t_orders " +
            "set " +
                "orders_type = 2 " +
            "where " +
                "orders_id = #{orderId}")
    void updateOrder(String orderId);

    @Select("select " +
                "orders_type " +
            "from " +
                "t_orders " +
            "where " +
                "orders_id = #{orderId}")
    Integer getOrderFlag(String orderId);
}
