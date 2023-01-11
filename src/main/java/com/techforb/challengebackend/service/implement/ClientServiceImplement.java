package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.ClientDTO;
import com.techforb.challengebackend.models.Client;
import com.techforb.challengebackend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplement implements ClientService{

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<ClientDTO> getClientsDTO() {
        return clientRepository.findAll().stream().map(client ->  new ClientDTO(client)).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientDTO(Long id) {
        return clientRepository.findById(id).map(client -> new ClientDTO(client)).orElse(null);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientByDni(int dni) {
        return clientRepository.findByDni(dni);
    }



}

