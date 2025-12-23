package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.OrderException;
import com.kashima.ecom_backend.model.Address;
import com.kashima.ecom_backend.model.Order;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.repository.CartRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private CartRepository cartRepository;
    private CartService cartService;
    private ProductService productService;

    public OrderServiceImpl(CartRepository cartRepository, CartService cartService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public Order createOrder(User user, Address shippingAddress) throws OrderException {

        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
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
