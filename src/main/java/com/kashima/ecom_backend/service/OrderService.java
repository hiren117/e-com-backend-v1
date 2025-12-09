package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.OrderException;
import com.kashima.ecom_backend.model.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order) throws OrderException;

    public Order findOrderById(String id) throws OrderException;
    public List<Order> userOrderHistory(Long userId) throws OrderException;
    public Order placeOrder(Long orderId) throws OrderException;
    public Order confirmOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order cancelOrder(Long orderId) throws OrderException;
    public Order deleteOrder(Long orderId) throws OrderException;

    public List<Order> getAllOrders();
}
