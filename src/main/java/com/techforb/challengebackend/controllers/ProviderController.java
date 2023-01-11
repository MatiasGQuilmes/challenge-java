package com.techforb.challengebackend.controllers;

import com.techforb.challengebackend.DTOS.ClientDTO;
import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.DTOS.SaleDTO;
import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Provider;
import com.techforb.challengebackend.service.ProductService;
import com.techforb.challengebackend.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProviderController {

    @Autowired
    ProviderService providerService;


    @GetMapping("/provider")
    public List<ProviderDTO> getListOfProviders(){
        return providerService.getProvidersDTO();
    }

    @GetMapping("/provider/{id}")
    public ProviderDTO getProvider(@PathVariable Long id){
        return providerService.getProviderDTO(id);
    }


    @PatchMapping("/provider/active")
    public ResponseEntity<?> activeProvider(
            @RequestParam long id
    ){
        if(id == 0){
            return new ResponseEntity<>("The id is 0", HttpStatus.FORBIDDEN);
        }
        Provider providerFound = providerService.findById(id);
        if(providerFound == null){

            return new ResponseEntity<>("the client is not exists", HttpStatus.FORBIDDEN);

        }
        providerFound.setActive(true);


        providerService.saveProvider(providerFound);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/provider/delete")
    public ResponseEntity<?> deleteProvider(
            @RequestParam long id
    ){
        if(id == 0){
            return new ResponseEntity<>("The id is 0", HttpStatus.FORBIDDEN);
        }
        Provider providerFound = providerService.findById(id);
        if(providerFound == null){

            return new ResponseEntity<>("the client is not exists", HttpStatus.FORBIDDEN);

        }
        providerFound.setActive(false);


        providerService.saveProvider(providerFound);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/provider/update")
    public ResponseEntity<?> updateProduct(
            @RequestParam String name,
            @RequestParam String cuit,
            @RequestParam long cellPhone,
            @RequestParam String address,
            @RequestParam long id
    ){




        if(cellPhone < 0){
            return new ResponseEntity<>("the stock cannot be less than 0", HttpStatus.FORBIDDEN);
        }
        if(id < 0){
            return new ResponseEntity<>("the stock cannot be less than 0", HttpStatus.FORBIDDEN);
        }


        Provider providerFound =  providerService.findById(id);

        if(providerFound == null){
            return new ResponseEntity<>("The id not exist", HttpStatus.FORBIDDEN);
        }

        providerFound.setName(name);
        providerFound.setCuit(cuit);
        providerFound.setCellPhone(cellPhone);
        providerFound.setAddress(address);

        providerService.saveProvider(providerFound);


        return new ResponseEntity<>(HttpStatus.OK);
    }






}
