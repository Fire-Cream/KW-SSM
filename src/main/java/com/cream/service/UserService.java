package com.cream.service;

import com.cream.domain.User;

public interface UserService {
    //登录方法
    User loginUser(String username, String password);

    //注册方法
    int registerUser(User user);

    //判断用户是否存在
    User existUser(String username);
}
