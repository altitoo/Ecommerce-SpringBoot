package com.ecommerce2.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.ecommerce2.orms.DB.Entities.OrderEntity;
import com.ecommerce2.orms.DB.Entities.OrderProductEntity;
import com.ecommerce2.orms.DB.Entities.ProductEntity;
import com.ecommerce2.orms.DB.Repositories.OrderProductRepository;
import com.ecommerce2.orms.DB.Repositories.OrderRepository;
import com.ecommerce2.orms.DB.Repositories.ProductRepository;
import com.ecommerce2.orms.Services.Models.OrderDTO;
import com.ecommerce2.orms.Services.Models.OrderProductDTO;
import com.ecommerce2.orms.Services.Models.ProductDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired 
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getOrders() {
        return orderRepository.findAll().stream()
             .map(order -> modelMapper.map(order, OrderDTO.class))
             .collect(Collectors.toList());
    }

    public Optional<OrderDTO> getOrderById(Long id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (orderEntity.isPresent()) {
            return Optional.of(modelMapper.map(orderEntity.get(), OrderDTO.class));
        }
        return Optional.empty();
    }

    public OrderDTO add(OrderDTO orderDTO) {
        OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
        orderEntity = orderRepository.save(orderEntity);
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    public OrderDTO update(Long id, OrderDTO orderDTO) {
        OrderEntity orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
        orderEntity.setId(id);
        orderEntity = orderRepository.save(orderEntity);
        return modelMapper.map(orderEntity, OrderDTO.class);
    }
    public void delete(Long id) {
       Optional<OrderEntity> orderEntity = orderRepository.findById(id);
       if(orderEntity.isPresent()) {
           orderRepository.delete(orderEntity.get());
       }
    }

   // Add product to orderproduct in order
    public OrderProductDTO addProductToOrder(Long orderId, Long productId, int quantity) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        OrderProductEntity orderProduct;
        try {
            orderProduct = orderProductRepository.findAll().stream()
            .filter(orderProductEntity -> orderProductEntity.getOrder().getId().equals(orderId))
            .filter(orderProductEntity-> orderProductEntity.getProduct().getId().equals(productId))
            .collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            orderProduct = null;
        }
        if (orderEntity.isPresent()) {

            if(orderProduct != null){
                // Update quantity
                orderProduct.setQuantity(orderProduct.getQuantity() + quantity);
                orderProductRepository.save(orderProduct);
                
            }
            else{
                 // Add new product to order
                OrderProductEntity orderProductEntity = new OrderProductEntity();
                orderProductEntity.setOrder(orderEntity.get());
                orderProductEntity.setQuantity(quantity);
                orderProductEntity.setProduct(productRepository.findById(productId).get());
                orderProductRepository.save(orderProductEntity);
            }
           
            
            
        }
        return null;
    
    }
    public OrderProductDTO deleteProductToOrder(Long orderId, Long productId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        OrderProductEntity orderProduct;
        try {
            orderProduct = orderProductRepository.findAll().stream()
            .filter(orderProductEntity -> orderProductEntity.getOrder().getId().equals(orderId))
            .filter(orderProductEntity-> orderProductEntity.getProduct().getId().equals(productId))
            .collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            orderProduct = null;
        }

        if (orderEntity.isPresent()) {

            if(orderProduct != null){
                // Update quantity
                orderProductRepository.delete(orderProduct);
                orderProductRepository.flush();
                
            }
        }
        return null;
    
    }
      
            
}
