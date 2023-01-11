package com.techforb.challengebackend.DTOS;

import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Provider;
import com.techforb.challengebackend.models.ProviderProduct;
import com.techforb.challengebackend.models.Sale;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProviderDTO {

    private long id;
    private String name;
    private String cuit;
    private long cellPhone;
    private String address;


    private boolean active;

    public ProviderDTO() {
    }

    public ProviderDTO(Provider provider) {
       this.id = provider.getId();
       this.name = provider.getName();
       this.cuit = provider.getCuit();
       this.cellPhone = provider.getCellPhone();
       this.address = provider.getAddress();
       this.active = provider.isActive();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCuit() {
        return cuit;
    }

    public long getCellPhone() {
        return cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActive() {
        return active;
    }
}
