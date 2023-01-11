package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.ClientDTO;
import com.techforb.challengebackend.DTOS.ProductDTO;
import com.techforb.challengebackend.models.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductsDTO();

    ProductDTO getProductDTO(Long id);

     void saveProduct(Product product);

     Product findById(long id);



}
