package com.techforb.challengebackend.models;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String cuit;
    private long cellPhone;
    private String address;
    private boolean active = true;

    @OneToMany(mappedBy = "provider",fetch = FetchType.EAGER)
    Set<ProviderProduct> products = new HashSet<>();



    public Provider() {
    }

    public Provider(String name, String cuit, long cellPhone, String address) {
        this.name = name;
        this.cuit = cuit;
        this.cellPhone = cellPhone;
        this.address = address;
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public Set<ProviderProduct> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setProducts(Set<ProviderProduct> products) {
        this.products = products;
    }



}
