package com.techforb.challengebackend.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long id;

    private String name;
    private String description;
    private double price;
    private int stock;

    private boolean active = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Provider provider;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<ProviderProduct> providers = new HashSet<>();


//    @ManyToOne(fetch = FetchType.EAGER)
//    List<SaleProduct> providers = new ArrayList<>();


    public Product() {
    }

    public Product(String name, String description, double price, int stock, Provider provider) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.provider = provider;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public Set<ProviderProduct> getProviders() {
        return providers;
    }

    public void setProviders(Set<ProviderProduct> providers) {
        this.providers = providers;
    }

    //    public List<SaleProduct> getProducts() {
//        return products;
//    }


    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
