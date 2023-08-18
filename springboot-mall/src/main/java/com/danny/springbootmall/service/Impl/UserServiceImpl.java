package com.danny.springbootmall.service.Impl;

import com.danny.springbootmall.dao.UserDao;
import com.danny.springbootmall.dto.UserRegiserRequest;
import com.danny.springbootmall.model.User;
import com.danny.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegiserRequest userRegiserRequest) {
        User user=userDao.getUserByEmail(userRegiserRequest.getEmail());
        //檢查註冊 email
        if(user!=null){
            log.warn("該 email {} 已經被註冊",userRegiserRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 創建帳號
        return userDao.createUser(userRegiserRequest);
    }
}
