package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.OrderException;
import com.kashima.ecom_backend.model.Address;
import com.kashima.ecom_backend.model.Order;
import com.kashima.ecom_backend.model.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(User user, Address shippingAddress) throws OrderException;

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> userOrderHistory(Long userId) throws OrderException;

    public Order placeOrder(Long orderId) throws OrderException;

    public Order confirmOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order cancelOrder(Long orderId) throws OrderException;

    public void deleteOrder(Long orderId) throws OrderException;

    public List<Order> getAllOrders();
}
