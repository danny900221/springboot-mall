package com.danny.springbootmall.service.Impl;

import com.danny.springbootmall.dao.UserDao;
import com.danny.springbootmall.dto.UserRegiserRequest;
import com.danny.springbootmall.model.User;
import com.danny.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegiserRequest userRegiserRequest) {
        return userDao.createUser(userRegiserRequest);
    }
}
