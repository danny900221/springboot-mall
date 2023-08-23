package com.danny.springbootmall.service;

import com.danny.springbootmall.dto.CreateOrderRequest;
import com.danny.springbootmall.dto.OrderQueryParams;
import com.danny.springbootmall.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer countOrder(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);
}
