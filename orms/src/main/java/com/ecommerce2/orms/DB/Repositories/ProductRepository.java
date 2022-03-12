package com.ecommerce2.orms.DB.Repositories;

import java.util.Optional;

import com.ecommerce2.orms.DB.Entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // find by id
    Optional<ProductEntity> findById(Long id);

}
    

