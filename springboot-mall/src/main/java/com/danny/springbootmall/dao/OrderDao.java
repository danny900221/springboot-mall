package com.danny.springbootmall.dao;

import com.danny.springbootmall.model.Order;
import com.danny.springbootmall.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer integer,Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
