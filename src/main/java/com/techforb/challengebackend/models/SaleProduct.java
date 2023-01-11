package com.techforb.challengebackend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long id;
    private int quantity;
    private double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product products;


    public SaleProduct() {
    }

    public SaleProduct(int quantity, Product product) {
        this.quantity = quantity;
        this.totalPrice = quantity*product.getPrice();
        this.products = product;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }



}
