package com.techforb.challengebackend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private LocalDate date;

    private double totalPrice;

    @OneToMany(mappedBy = "sale",fetch = FetchType.EAGER)
    List<SaleProduct> products;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public Sale() {
    }

    public Sale(LocalDate date, List<SaleProduct> saleProduct , Client client) {
        this.date = date;
        this.client = client;
        this.products = saleProduct;
        saleProduct.forEach( product -> this.totalPrice +=  product.getTotalPrice());
    }

    public long getId() {
        return id;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<SaleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SaleProduct> products) {
        this.products = products;
    }

    public void addSale(SaleProduct saleProduct) {

        saleProduct.setSale(this);
        products.add(saleProduct);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
