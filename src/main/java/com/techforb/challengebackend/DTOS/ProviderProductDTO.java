package com.techforb.challengebackend.DTOS;

import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Provider;
import com.techforb.challengebackend.models.ProviderProduct;

public class ProviderProductDTO {

    private long id;

    private String product;

    private String provider;


    public ProviderProductDTO() {
    }

    public ProviderProductDTO(ProviderProduct providerProduct) {
        this.product = providerProduct.getProduct().getName();
        this.provider = providerProduct.getProvider().getName();
    }

    public String getProduct() {
        return product;
    }

    public String getProvider() {
        return provider;
    }



}
