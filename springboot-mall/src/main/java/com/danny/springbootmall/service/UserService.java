package com.danny.springbootmall.service;

import com.danny.springbootmall.dto.UserLoginRequest;
import com.danny.springbootmall.dto.UserRegisterRequest;
import com.danny.springbootmall.model.User;

public interface UserService {
    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

}
