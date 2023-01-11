package com.techforb.challengebackend.repositories;

import com.techforb.challengebackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findAllByid(Long id);

}
