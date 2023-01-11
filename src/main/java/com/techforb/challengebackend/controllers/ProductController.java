package com.techforb.challengebackend.controllers;

import com.techforb.challengebackend.DTOS.ProductDTO;
import com.techforb.challengebackend.DTOS.ProviderProductDTO;
import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<ProductDTO> getListOfProducts()
    {
        return productService.getProductsDTO();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@RequestParam Long id){

        return productService.getProductDTO(id);
    }


    @PatchMapping("/products/active")
    public ResponseEntity<?> activeProduct(
            @RequestParam long id
        ){
        if(id == 0){
            return new ResponseEntity<>("The id is 0",HttpStatus.FORBIDDEN);
        }
        Product productFound = productService.findById(id);
        if(productFound == null){

            return new ResponseEntity<>("the client is not exists", HttpStatus.FORBIDDEN);

        }
        productFound.setActive(true);


        productService.saveProduct(productFound);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/products/delete")
    public ResponseEntity<?> deleteProduct(
            @RequestParam long id
    ){
        if(id == 0){
            return new ResponseEntity<>("The id is 0",HttpStatus.FORBIDDEN);
        }
        Product productFound = productService.findById(id);
        if(productFound == null){

            return new ResponseEntity<>("the client is not exists", HttpStatus.FORBIDDEN);

        }
        productFound.setActive(false);


        productService.saveProduct(productFound);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/products/update")
    public ResponseEntity<?> updateProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Integer stock,
            @RequestParam double price,
            @RequestParam long id
    ){

        if(stock < 0){
            return new ResponseEntity<>("the stock cannot be less than 0", HttpStatus.FORBIDDEN);
        }
        if(price < 0){
            return new ResponseEntity<>("the stock cannot be less than 0", HttpStatus.FORBIDDEN);
        }


        Product productFound =  productService.findById(id);

        if(productFound == null){
            return new ResponseEntity<>("The id not exist", HttpStatus.FORBIDDEN);
        }

        productFound.setName(name);
        productFound.setDescription(description);
        productFound.setStock(stock);
        productFound.setPrice(price);

        productService.saveProduct(productFound);


        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/products/purchasesProvider")
    public List<ProductDTO> purchasesProvider(@RequestParam String nameProvider){


        return productService.getProductsDTO().stream().filter( product -> product.getProvider().equals(nameProvider)).collect(Collectors.toList());

    }






}
