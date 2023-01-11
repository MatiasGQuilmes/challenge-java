package com.techforb.challengebackend.repositories;


import com.techforb.challengebackend.models.ProviderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProviderProductRepository extends JpaRepository<ProviderProduct, Long> {
}
