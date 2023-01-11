package com.techforb.challengebackend.service.implement;

import com.techforb.challengebackend.DTOS.ProviderProductDTO;
import com.techforb.challengebackend.models.Client;
import com.techforb.challengebackend.models.ProviderProduct;
import com.techforb.challengebackend.repositories.ProviderProductRepository;
import com.techforb.challengebackend.service.ProviderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProviderProductServiceImplement implements ProviderProductService {

    @Autowired
    ProviderProductRepository providerProductRepository;


    @Override
    public List<ProviderProductDTO> getListOfProviderProductDTO() {
        return providerProductRepository.findAll().stream().map(providerProduct -> new ProviderProductDTO(providerProduct)).collect(Collectors.toList());
    }

    @Override
    public List<ProviderProduct> getListOfProviderProduct() {
        return providerProductRepository.findAll();
    }

//    @Override
//    public List<ProviderProductDTO> getListOfProviderProductDTO() {
//        return providerProductRepository.findAll().stream().map(providerProduct -> new ProviderProductDTO(providerProduct)).collect(Collectors.toList());
//    }

    @Override
    public ProviderProductDTO getProviderProductDTO(Long id) {
        return providerProductRepository.findById(id).map(providerProduct -> new ProviderProductDTO(providerProduct)).orElse(null);
    }


    @Override
    public Map<String, Object> getProviderProductsDTO(ProviderProduct providerProduct) {

        Map<String, Object> DTO = new LinkedHashMap<>();
        DTO.put("id",providerProduct.getProduct().getId());
        DTO.put("Product",providerProduct.getProduct().getName());
        DTO.put("Provider",providerProduct.getProvider().getName());
        DTO.put("stock",providerProduct.getProduct().getStock());
        return DTO;
    }





}
