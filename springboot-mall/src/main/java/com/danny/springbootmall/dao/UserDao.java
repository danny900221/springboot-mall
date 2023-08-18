package com.danny.springbootmall.dao;

import com.danny.springbootmall.dto.UserRegisterRequest;
import com.danny.springbootmall.model.User;

public interface UserDao {
    User getUserById(Integer userId);
    User getUserByEmail(String email);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
