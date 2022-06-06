package com.cream.service.impl;

import com.cream.domain.User;
import com.cream.mapper.UserMapper;
import com.cream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    //创建dao
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginUser(String username, String password) {
        return userMapper.loginUser(username, password);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public User existUser(String username) {
        return userMapper.existUser(username);
    }
}
