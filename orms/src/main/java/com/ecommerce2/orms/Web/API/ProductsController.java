package com.ecommerce2.orms.Web.API;

import java.util.List;

import com.ecommerce2.orms.Services.ProductService;
import com.ecommerce2.orms.Services.Models.ProductDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    
    private final ProductService productService;

    ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping()
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @PostMapping()
    public ProductDTO add(ProductDTO productDTO) {
        return productService.add(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO update(ProductDTO productDTO, @PathVariable("id") Long id) {
        return productService.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
