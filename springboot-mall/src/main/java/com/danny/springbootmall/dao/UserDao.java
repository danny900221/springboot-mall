package com.danny.springbootmall.dao;

import com.danny.springbootmall.dto.UserRegiserRequest;
import com.danny.springbootmall.model.User;

public interface UserDao {
    User getUserById(Integer userId);
    User getUserByEmail(String email);
    Integer createUser(UserRegiserRequest userRegiserRequest);
}
