package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.ClientDTO;
import com.techforb.challengebackend.models.Client;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getClientsDTO();

    ClientDTO getClientDTO(Long id);

    Client getClient(Long id);

    void saveClient(Client client);

    Client getClientByDni(int dni);




}
