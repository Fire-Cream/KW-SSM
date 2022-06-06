package com.cream.mapper;

import com.cream.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录方法
    User loginUser(@Param("username") String username, @Param("password") String password);

    //注册方法
    int registerUser(User user);

    //判断用户是否存在
    User existUser(@Param("username") String username);
}
