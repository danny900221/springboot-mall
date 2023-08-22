package com.danny.springbootmall.dao;

import com.danny.springbootmall.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {
    Integer createOrder(Integer integer,Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
