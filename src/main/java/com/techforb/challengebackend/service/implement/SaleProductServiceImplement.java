package com.techforb.challengebackend.service.implement;

import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.DTOS.SaleProductDTO;
import com.techforb.challengebackend.repositories.SaleProductRepository;
import com.techforb.challengebackend.service.SaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleProductServiceImplement implements SaleProductService {


    @Autowired
    SaleProductRepository saleProductRepository;

    @Override
    public List<SaleProductDTO> getListSaleProductsDTO() {
        return saleProductRepository.findAll().stream().map(saleProduct ->  new SaleProductDTO(saleProduct)).collect(Collectors.toList());
    }

    @Override
    public SaleProductDTO getSaleProductDTO(Long id) {
        return saleProductRepository.findById(id).map(saleProduct -> new SaleProductDTO(saleProduct)).orElse(null);
    }
}
