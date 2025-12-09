package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.OrderException;
import com.kashima.ecom_backend.model.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) throws OrderException {

        return null;
    }

    @Override
    public Order findOrderById(String id) throws OrderException {
        return null;
    }

    @Override
    public List<Order> userOrderHistory(Long userId) throws OrderException {
        return List.of();
    }

    @Override
    public Order placeOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order cancelOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deleteOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }
}
