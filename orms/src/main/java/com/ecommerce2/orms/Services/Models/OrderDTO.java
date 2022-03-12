package com.ecommerce2.orms.Services.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.ecommerce2.orms.DB.Entities.OrderProductEntity;
import com.ecommerce2.orms.Helpers.Enums.OrderState;

public class OrderDTO {
    
    private Long id;
    private Date createdAt;
    private String state;
    private String userName;
    private double totalPrice;
    private List<OrderProductDTO> orderProducts;

    public OrderDTO() {
        this.orderProducts = new ArrayList<>();
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public List<OrderProductDTO> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProducts(List<OrderProductDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
