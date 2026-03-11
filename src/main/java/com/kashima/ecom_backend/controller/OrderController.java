package com.kashima.ecom_backend.controller;

import com.kashima.ecom_backend.exception.OrderException;
import com.kashima.ecom_backend.exception.UserException;
import com.kashima.ecom_backend.model.Address;
import com.kashima.ecom_backend.model.Order;
import com.kashima.ecom_backend.model.User;
import com.kashima.ecom_backend.repository.OrderRepository;
import com.kashima.ecom_backend.service.OrderService;
import com.kashima.ecom_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,
                                             @RequestHeader("Authorization")String jwt) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(jwt);

        Order order = orderService.createOrder(user,shippingAddress);

        System.out.println("order created in order controller" + order);

        return new ResponseEntity<>(order, HttpStatus.CREATED);

    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistory(@RequestHeader("Authorization")String jwt) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Order> orderHistory = orderService.userOrderHistory(user.getId());
        return new ResponseEntity<>(orderHistory, HttpStatus.OK); // should it be CREATED
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("Id") Long orderId,
                                              @RequestHeader("Authorization")String jwt) throws OrderException, UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
