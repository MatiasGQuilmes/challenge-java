package com.techforb.challengebackend.DTOS;

import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Provider;
import com.techforb.challengebackend.models.ProviderProduct;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;

    private String provider;


    private boolean active;
    public ProductDTO() {
    }
    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.provider = product.getProvider().getName();
        this.active = product.isActive();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getProvider() {
        return provider;
    }

    public boolean isActive() {
        return active;
    }
}
