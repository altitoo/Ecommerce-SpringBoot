package com.ecommerce2.orms.Web.Config;

import com.ecommerce2.orms.Services.OrderService;
import com.ecommerce2.orms.Services.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Startup {

    @Bean
    ProductService createProductService() {
        return new ProductService();
    }

    @Bean
    OrderService createOrderService() {
        return new OrderService();
    }

    @Bean
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }


}
