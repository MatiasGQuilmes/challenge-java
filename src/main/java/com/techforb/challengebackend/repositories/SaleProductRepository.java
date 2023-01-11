package com.techforb.challengebackend.repositories;

import com.techforb.challengebackend.models.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {
}
