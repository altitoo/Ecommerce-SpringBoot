package com.ecommerce2.orms.Web.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ecommerce2.orms.DB.Entities.OrderEntity;
import com.ecommerce2.orms.DB.Entities.OrderProductEntity;
import com.ecommerce2.orms.DB.Entities.ProductEntity;
import com.ecommerce2.orms.DB.Repositories.OrderProductRepository;
import com.ecommerce2.orms.DB.Repositories.OrderRepository;
import com.ecommerce2.orms.DB.Repositories.ProductRepository;
import com.ecommerce2.orms.Helpers.Enums.OrderState;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {
    @Bean
    CommandLineRunner initDatabase(
        ProductRepository productRepository,
        OrderProductRepository orderProductRepository,
        OrderRepository orderRepository) {
        return args -> {
            
            // Create produts
            productRepository.save(new ProductEntity("TV",300.0, "https://img.icons8.com/color/96/000000/tv.png"));
            productRepository.save(new ProductEntity("Laptop",1200.0, "https://img.icons8.com/fluency/48/000000/laptop.png"));
            productRepository.save(new ProductEntity("Phone",500.0, "https://img.icons8.com/stickers/100/000000/iphone-x.png"));
            productRepository.save(new ProductEntity("Tablet",800.0, "https://img.icons8.com/officel/16/000000/ipad-mini.png"));
            

            // Create orders
            var orderEntity = new OrderEntity(new Date(), OrderState.NEW.toString(), "John Doe");
            orderRepository.save(orderEntity);
           
        
        };
    }
}
