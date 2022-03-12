package com.ecommerce2.orms.Web.API;

import java.util.List;

import com.ecommerce2.orms.Services.OrderService;
import com.ecommerce2.orms.Services.Models.OrderDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    
    private final OrderService orderService;

    OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }
    
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id).orElse(null);
    }

    @PostMapping()
    public OrderDTO add(OrderDTO orderDTO) {
        if(orderDTO.getId() == null) {
            return orderService.add(new OrderDTO());
        }
        return orderService.add(orderDTO);
    }

    @PutMapping("/{id}")
    public OrderDTO update(@PathVariable("id") Long id, OrderDTO orderDTO) {
        return orderService.update(id, orderDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

    @PostMapping("/{id}/products")
    public void addProduct(@PathVariable("id") Long id, Long productId, int quantity) {
        orderService.addProductToOrder(id, productId, quantity);
    }
    
    @DeleteMapping("/{id}/products/{productId}")
    public void deleteProduct(@PathVariable("id") Long id, @PathVariable("productId") Long productId) {
        orderService.deleteProductToOrder(id, productId);
    }
    /*

    @PutMapping("/{id}/products/{productId}")
    public void updateProduct(@PathVariable("id") Long id, @PathVariable("productId") Long productId, int quantity) {
        orderService.updateProduct(id, productId, quantity);
    }
    */

}
