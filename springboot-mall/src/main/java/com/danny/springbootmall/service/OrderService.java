package com.danny.springbootmall.service;

import com.danny.springbootmall.dto.CreateOrderRequest;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
