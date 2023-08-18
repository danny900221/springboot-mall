package com.danny.springbootmall.controller;

import com.danny.springbootmall.dto.UserLoginRequest;
import com.danny.springbootmall.dto.UserRegiserRequest;
import com.danny.springbootmall.model.User;
import com.danny.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegiserRequest userRegiserRequest){
        Integer userId=userService.register(userRegiserRequest);

        User user=userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        User user=userService.login(userLoginRequest);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
