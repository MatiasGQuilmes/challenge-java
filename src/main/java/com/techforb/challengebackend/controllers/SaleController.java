package com.techforb.challengebackend.controllers;


import com.techforb.challengebackend.DTOS.SaleDTO;
import com.techforb.challengebackend.models.Sale;
import com.techforb.challengebackend.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SaleController {


    @Autowired
    SaleService saleService;


    @GetMapping("/sale")
    public List<SaleDTO> getListOfSale(){
        return saleService.getListSaleDTO();
    }

    @GetMapping("/sale/{id}")
    public SaleDTO getSale(@RequestParam Long id){
        return saleService.getSaleDTO(id);
    }


    @GetMapping("/sale/salesMade")
    public List<SaleDTO> salesMade(@RequestParam LocalDate localDate){

        return  saleService.getListSaleDTO().stream().filter(sale -> sale.getDate().equals(localDate)).collect(Collectors.toList());

    }






}
