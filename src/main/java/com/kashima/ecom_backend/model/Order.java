package com.kashima.ecom_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    private LocalDateTime delivaryDate;

    @OneToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private double totalPrice;

    private Integer totalDiscountedPrice;

    private Integer discount;

    private String orderStatus;

    private int totalItems;

    private LocalDateTime createdAt;

    public Order(Long id, String orderId, User user, List<OrderItem> orderItems, LocalDateTime orderDate, LocalDateTime delivaryDate, Address shippingAddress, PaymentDetails paymentDetails, double totalPrice, Integer totalDiscountedPrice, Integer discount, String orderStatus, int totalItems, LocalDateTime createdAt) {
        super();
        this.id = id;
        this.orderId = orderId;
        this.user = user;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.delivaryDate = delivaryDate;
        this.shippingAddress = shippingAddress;
        this.paymentDetails = paymentDetails;
        this.totalPrice = totalPrice;
        this.totalDiscountedPrice = totalDiscountedPrice;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.totalItems = totalItems;
        this.createdAt = createdAt;
    }
    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDelivaryDate() {
        return delivaryDate;
    }

    public void setDelivaryDate(LocalDateTime delivaryDate) {
        this.delivaryDate = delivaryDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }

    public void setTotalDiscountedPrice(Integer totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
