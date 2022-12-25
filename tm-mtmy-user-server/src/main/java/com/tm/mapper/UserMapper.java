package com.tm.mapper;

import com.tm.entity.User;
import com.tm.entity.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where user_phone = #{userPhone}")
    User queryUserByPhoneNumber(String userPhone);


    @Insert("insert into t_user (user_name,user_phone,user_pwd) values(#{userName},#{userPhone},#{userPwd})")
    void addUser(UserDTO userDTO);

    @Select("select * from t_user where user_name = #{userName}")
    User queryUserByName(String userName);
}
