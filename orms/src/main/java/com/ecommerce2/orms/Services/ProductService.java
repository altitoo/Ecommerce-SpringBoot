package com.ecommerce2.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ecommerce2.orms.DB.Entities.ProductEntity;
import com.ecommerce2.orms.DB.Repositories.ProductRepository;
import com.ecommerce2.orms.Services.Models.ProductDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getProducts() {
       return productRepository.findAll().stream()
            .map(product -> modelMapper.map(product, ProductDTO.class))
            .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            return Optional.of(modelMapper.map(productEntity.get(), ProductDTO.class));
        }
        return Optional.empty();
    }

    public ProductDTO add(ProductDTO productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        productEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        productEntity.setId(id);
        productEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductDTO.class);
    }
    public void delete(Long id) {
       Optional<ProductEntity> productEntity = productRepository.findById(id);
       if(productEntity.isPresent()) {
           productRepository.delete(productEntity.get());
       }
    }
}
