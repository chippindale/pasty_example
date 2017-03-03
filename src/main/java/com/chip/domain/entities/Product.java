package com.chip.domain.entities;


import org.springframework.data.annotation.Id;

/**
 * Created by Chloe on 03/03/2017.
 */
public class Product {
    @Id
    private Long productID;
    private Enum<ProductType> ProductType;
    private String name;
    private double price;
    private String description;
    private double cost;
    private double profit;

    public Product(Enum<com.chip.domain.entities.ProductType> productType, String name, double price, String description, double cost) {
        ProductType = productType;
        this.name = name;
        this.price = price;
        this.description = description;
        this.cost = cost;
        this.profit = price - cost;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Enum<com.chip.domain.entities.ProductType> getProductType() {
        return ProductType;
    }

    public void setProductType(Enum<com.chip.domain.entities.ProductType> productType) {
        ProductType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
