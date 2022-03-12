package com.ecommerce2.orms.Web.View;

import com.ecommerce2.orms.Services.ProductService;
import com.ecommerce2.orms.Services.Models.ProductDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("products")
public class ProductsViewController {

    private final ProductService productService;

    ProductsViewController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView EditProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detailProduct");
        var product = productService.getProductById(id);
        ProductDTO productDTO = new ProductDTO();
        if(product.isPresent()) {
            productDTO = product.get();
        }
        modelAndView.addObject("product", productDTO);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView AddProduct() {
        ModelAndView modelAndView = new ModelAndView("detailProduct");
        modelAndView.addObject("product", new ProductDTO());
        return modelAndView;
    }
    @GetMapping("/view")
    public ModelAndView ListProducts() {
        ModelAndView modelAndView = new ModelAndView("listProducts");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }

    
}
