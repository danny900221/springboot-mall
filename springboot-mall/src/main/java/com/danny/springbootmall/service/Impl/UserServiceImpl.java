package com.danny.springbootmall.service.Impl;

import com.danny.springbootmall.dao.UserDao;
import com.danny.springbootmall.dto.UserLoginRequest;
import com.danny.springbootmall.dto.UserRegiserRequest;
import com.danny.springbootmall.model.User;
import com.danny.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
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
        //使用 MD5 生成密碼雜湊質
        String hashedPassword= DigestUtils.md5DigestAsHex(userRegiserRequest.getPassword().getBytes());
        userRegiserRequest.setPassword(hashedPassword);
        // 創建帳號
        return userDao.createUser(userRegiserRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user=userDao.getUserByEmail(userLoginRequest.getEmail());
        //檢查User 是否存在
        if(user==null){
            log.warn("該 email {} 尚未註冊",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用 MD5 生成密碼雜湊質
        String hashedPassword=DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());


        //比較密碼
        if(user.getPassword().equals(hashedPassword)){
            return user;

        }else{
            log.warn("該 email {} 的密碼不正確",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
