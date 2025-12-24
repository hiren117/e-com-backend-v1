package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.model.OrderItem;
import com.kashima.ecom_backend.repository.OrderItemRepository;

public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
