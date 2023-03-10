package com.techforb.challengebackend.repositories;

import com.techforb.challengebackend.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
