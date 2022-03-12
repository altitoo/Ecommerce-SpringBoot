package com.ecommerce2.orms.Services.Models;

import com.ecommerce2.orms.DB.Entities.OrderEntity;
import com.ecommerce2.orms.DB.Entities.ProductEntity;

public class OrderProductDTO {
    
    private Long Id;
    private int quantity;
    private ProductDTO product;
    
    
    public Long getId() {
        return Id;
    }
    
    public ProductDTO getProduct() {
        return product;
    }
    public void setProduct(ProductDTO product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setId(Long id) {
        this.Id = id;
    }


  
    
}
