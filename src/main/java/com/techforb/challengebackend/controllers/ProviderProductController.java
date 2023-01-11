package com.techforb.challengebackend.controllers;

import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.DTOS.ProviderProductDTO;
import com.techforb.challengebackend.DTOS.SaleDTO;
import com.techforb.challengebackend.models.ProviderProduct;
import com.techforb.challengebackend.service.ProviderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProviderProductController {

    @Autowired
    ProviderProductService providerProductService;


    @GetMapping("/providerProducts")
    public List<ProviderProductDTO> getListOfProviderProducts() {
        return providerProductService.getListOfProviderProductDTO();
    }

    @GetMapping("/providerProducts/{id}")
    public ProviderProductDTO getProviderProduct(@PathVariable Long id) {
        return providerProductService.getProviderProductDTO(id);
    }


    @GetMapping("/providerProducts/slowStock")
    public List<Map<String,Object>> slowStock(@RequestParam int stock){

        List<Map<String,Object>> ProviderProducts = providerProductService.getListOfProviderProduct().stream()
                .filter(provider -> provider.getProduct().getStock() < 60)
                .map(providerProduct -> providerProductService.getProviderProductsDTO(providerProduct))
                .collect(Collectors.toList());

        return ProviderProducts;

    }

//    @GetMapping("/providerProducts/purchasesProvider")
//    public List<ProviderProductDTO> purchasesProvider(@RequestParam String nameProvider){
//
//
//
//
//        return "";
//
//    }

}
