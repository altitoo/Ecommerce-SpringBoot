package com.ecommerce2.orms.DB.Repositories;

import java.util.Optional;

import com.ecommerce2.orms.DB.Entities.OrderProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> { 
    
    Optional<OrderProductEntity> findAllByOrder(Long id);
}
