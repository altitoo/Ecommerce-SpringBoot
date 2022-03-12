package com.ecommerce2.orms.Web.View;

import com.ecommerce2.orms.Services.OrderService;
import com.ecommerce2.orms.Services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("orders")
public class OrdersViewController {
    

    private final ProductService productService;
    private final OrderService orderService;

    OrdersViewController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    /*
    @GetMapping("/{id}/products")
    public ModelAndView ListProducts() {
        ModelAndView modelAndView = new ModelAndView("listProducts");
        modelAndView.addObject("orders", orderService.getOrders());
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }
    */

    @GetMapping("/view")
    public ModelAndView ListOrders() {
        ModelAndView modelAndView = new ModelAndView("listOrders");
        modelAndView.addObject("orders", orderService.getOrders());
        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView orderDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detailOrder");
        modelAndView.addObject("orders", orderService.getOrderById(id).get());
        return modelAndView;
    }
}
