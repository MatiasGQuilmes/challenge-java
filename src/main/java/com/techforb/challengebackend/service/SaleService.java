package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.SaleDTO;

import java.util.List;

public interface SaleService {

    List<SaleDTO> getListSaleDTO();

    SaleDTO getSaleDTO(Long id);


}
