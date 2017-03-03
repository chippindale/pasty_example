package com.chip.domain.entities;

import org.springframework.data.annotation.Id;

import java.util.HashMap;

/**
 * Created by Chloe on 03/03/2017.
 */
public class Order {
    @Id
    private Long orderID;
    private User User;
    private HashMap<Product,Integer> productOrdered;
    private String date;

    public Order(User User, HashMap<Product, Integer> productOrdered, String date) {
        this.User = User;
        this.productOrdered = productOrdered;
        this.date = date;
    }

    public void addProductToOrder(Product product, int amount){
        productOrdered.put(product, amount);
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public HashMap<Product, Integer> getProductOrdered() {
        return productOrdered;
    }

    public void setProductOrdered(HashMap<Product, Integer> productOrdered) {
        this.productOrdered = productOrdered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
