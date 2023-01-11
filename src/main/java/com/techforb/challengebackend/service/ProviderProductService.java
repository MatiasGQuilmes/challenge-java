package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.ProviderProductDTO;
import com.techforb.challengebackend.models.ProviderProduct;

import java.util.List;
import java.util.Map;

public interface ProviderProductService {

    List<ProviderProductDTO> getListOfProviderProductDTO();
    List<ProviderProduct> getListOfProviderProduct();

    Map<String, Object>  getProviderProductsDTO(ProviderProduct providerProduct);

    ProviderProductDTO getProviderProductDTO(Long id);



}
