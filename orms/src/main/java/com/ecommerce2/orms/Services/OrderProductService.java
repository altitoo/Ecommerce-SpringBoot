package com.ecommerce2.orms.Services;

import java.util.Optional;

import com.ecommerce2.orms.DB.Entities.OrderProductEntity;
import com.ecommerce2.orms.DB.Repositories.OrderProductRepository;
import com.ecommerce2.orms.Services.Models.OrderProductDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class OrderProductService {
    
    @Autowired
    private OrderProductRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    public OrderProductDTO getOrderProductById(Long id) {
        
        Optional<OrderProductEntity> orderEntity = orderRepository.findById(id);
        if (orderEntity.isPresent()) {
            return modelMapper.map(orderEntity.get(), OrderProductDTO.class);
        }
        return null;
    }
}
