package com.chip.domain.Entities;


import org.springframework.data.annotation.Id;

/**
 * Created by Chloe on 03/03/2017.
 */
public class Product {
    @Id
    private String id;
    private ProductType type;
    private String name;
    private double price;
    private String description;
    private double cost;
    private double profit;

    public Product(ProductType type, String name, double price, String description, double cost) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.description = description;
        this.cost = cost;
        this.profit = price - cost;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", profit=" + profit +
                '}';
    }
}
