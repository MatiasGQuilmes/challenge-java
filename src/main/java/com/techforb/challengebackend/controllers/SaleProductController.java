package com.techforb.challengebackend.controllers;


import com.techforb.challengebackend.DTOS.SaleProductDTO;
import com.techforb.challengebackend.repositories.SaleProductRepository;
import com.techforb.challengebackend.service.SaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SaleProductController {

    @Autowired
    SaleProductService saleProductService;


    @GetMapping("/saleProducts")
    public List<SaleProductDTO> getListSale(){
        return saleProductService.getListSaleProductsDTO();
    }






}
