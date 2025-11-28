package com.kashima.ecom_backend.model;

// this is not an entity ,, we have made it embeded

public class Size {

    private String name; // meaning M,L,XL,S etc..
    private int quantity;

    public Size() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
