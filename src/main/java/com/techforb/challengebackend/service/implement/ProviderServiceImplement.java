package com.techforb.challengebackend.service.implement;

import com.techforb.challengebackend.DTOS.ProviderDTO;
import com.techforb.challengebackend.models.Product;
import com.techforb.challengebackend.models.Provider;
import com.techforb.challengebackend.repositories.ProviderRepository;
import com.techforb.challengebackend.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImplement implements ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    @Override
    public List<ProviderDTO> getProvidersDTO() {
        return providerRepository.findAll().stream().map(provider ->  new ProviderDTO(provider)).collect(Collectors.toList());
    }

    @Override
    public ProviderDTO getProviderDTO(Long id) {
        return providerRepository.findById(id).map(provider -> new ProviderDTO(provider)).orElse(null);
    }

    @Override
    public Provider findById(long id) {
        return providerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProvider(Provider provider) {
        providerRepository.save(provider);
    }


}
