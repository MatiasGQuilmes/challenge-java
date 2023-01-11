package com.techforb.challengebackend.service.implement;

import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.DTOS.SaleDTO;
import com.techforb.challengebackend.repositories.SaleRepository;
import com.techforb.challengebackend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImplement implements SaleService {


    @Autowired
    SaleRepository saleRepository;


    @Override
    public List<SaleDTO> getListSaleDTO() {
        return saleRepository.findAll().stream().map(sale ->  new SaleDTO(sale)).collect(Collectors.toList());
    }

    @Override
    public SaleDTO getSaleDTO(Long id) {
        return saleRepository.findById(id).map(sale -> new SaleDTO(sale)).orElse(null);
    }
}
