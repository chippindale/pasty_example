package com.chip.domain.entities;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

/**
 * Created by Chloe on 03/03/2017.
 */
public class Order {
    @Id
    private String id;
    private String userAccountNum;
    private Product[] products;
    private int[] amounts;
    private String date;

    public Order(String userAccountNum, Product[] products, int[]amounts, String date) {
        this.userAccountNum = userAccountNum;
        this.products = products;
        this.amounts = amounts;
        this.date = date;
    }


    public String getUserAccountNum() {
        return userAccountNum;
    }

    public void setUserAccountNum(String userAccountNum) {
        this.userAccountNum = userAccountNum;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int[] getAmounts() {
        return amounts;
    }

    public void setAmounts(int[] amounts) {
        this.amounts = amounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + userAccountNum +
                ", products=" + Arrays.toString(products) +
                ", amounts=" + Arrays.toString(amounts) +
                ", date='" + date + '\'' +
                '}';
    }
}
