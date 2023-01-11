package com.techforb.challengebackend.service;

import com.techforb.challengebackend.DTOS.ClientDTO;
import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Provider;

import java.util.List;

public interface ProviderService {
    List<ProviderDTO> getProvidersDTO();

    ProviderDTO getProviderDTO(Long id);

    Provider findById(long id);

    void saveProvider(Provider provider);

}
