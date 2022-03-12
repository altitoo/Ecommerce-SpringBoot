package com.ecommerce2.orms.DB.Repositories;

import java.util.Optional;

import com.ecommerce2.orms.DB.Entities.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> { 
    
    Optional<OrderEntity> findById(Long id);
}
