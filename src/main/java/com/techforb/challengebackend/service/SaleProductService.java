package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.SaleDTO;
import com.techforb.challengebackend.DTOS.SaleProductDTO;

import java.util.List;

public interface SaleProductService {

    List<SaleProductDTO> getListSaleProductsDTO();

    SaleProductDTO getSaleProductDTO(Long id);
}
