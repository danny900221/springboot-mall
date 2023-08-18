package com.danny.springbootmall.service;

import com.danny.springbootmall.dto.UserRegiserRequest;
import com.danny.springbootmall.model.User;

public interface UserService {
    User getUserById(Integer userId);
    Integer register(UserRegiserRequest userRegiserRequest);

}
