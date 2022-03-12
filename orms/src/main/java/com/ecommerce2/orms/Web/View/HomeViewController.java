package com.ecommerce2.orms.Web.View;

import com.ecommerce2.orms.Services.OrderService;
import com.ecommerce2.orms.Services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeViewController {

    private final ProductService productService;
    private final OrderService orderService;

    HomeViewController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("order", orderService.getOrderById(Long.valueOf(orderService.getOrders().size())).get());
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }
    
}
