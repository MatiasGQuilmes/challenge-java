package com.techforb.challengebackend.controllers;

import com.techforb.challengebackend.DTOS.ClientDTO;
import com.techforb.challengebackend.models.Client;
import com.techforb.challengebackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<ClientDTO> getListOfClients(){
        return clientService.getClientsDTO();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable Long id){
        return clientService.getClientDTO(id);
    }



    @PatchMapping("/clients/active")
    public ResponseEntity<Object> activeClient(@RequestParam long id){

        if(id == 0){
            return new ResponseEntity<>("The id is 0",HttpStatus.FORBIDDEN);
        }

        Client clientFound = clientService.getClient(id);

        if(clientFound == null){

            return new ResponseEntity<>("the client is not exists", HttpStatus.FORBIDDEN);

        }

        clientFound.setActive(true);
        clientService.saveClient(clientFound);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/clients/delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable long id){

        if(id == 0){
            return new ResponseEntity<>("The id is 0",HttpStatus.FORBIDDEN);
        }

        Client clientFound = clientService.getClient(id);

        if(clientFound == null){

            return new ResponseEntity<>("the client is not exists", HttpStatus.FORBIDDEN);

        }

        clientFound.setActive(false);
        clientService.saveClient(clientFound);

        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PatchMapping("/clients/update")
    public ResponseEntity<Object> updateClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int dni,
            @RequestParam long cellPhone,
            @RequestParam String address
    ){


        if(dni == 0 ){
            return new ResponseEntity<>("The dni is 0",HttpStatus.FORBIDDEN);
        }
        if(cellPhone == 0){
            return new ResponseEntity<>("The cell phone is 0",HttpStatus.FORBIDDEN);
        }


        Client clientFound = clientService.getClientByDni(dni);
        if(clientFound == null){
            return new ResponseEntity<>("the dni not exist", HttpStatus.FORBIDDEN);
        }

        clientFound.setFirstname(firstName);
        clientFound.setLastname(lastName);
        clientFound.setCellPhone(cellPhone);
        clientFound.setAddress(address);

        clientService.saveClient(clientFound);

        return new ResponseEntity<>(HttpStatus.OK);

    }










}
