package com.techforb.challengebackend.service.implement;

import com.techforb.challengebackend.DTOS.ProductDTO;
import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.repositories.ProductRepository;
import com.techforb.challengebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public List<ProductDTO> getProductsDTO() {
        return productRepository.findAll().stream().map(product ->  new ProductDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductDTO(Long id) {
        return productRepository.findById(id).map(product -> new ProductDTO(product)).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }




}
