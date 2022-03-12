package com.ecommerce2.orms.DB.Entities;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecommerce2.orms.Helpers.Enums.OrderState;



@Entity(name = "orders")
@Table(name = "orders")
public class OrderEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private  Long id;

    @Column(name = "date")
    private Date createdAt;
    @Column(name = "state")
    private String state;
    @Column(name = "name")
    private String userName;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    Set<OrderProductEntity> orderProducts;

    private double totalPrice;

    public OrderEntity() {
        this.createdAt = new Date();
        
    }

    
    public OrderEntity(Date createdAt, String state, String userName) {
        this.createdAt = createdAt;
        this.state = state;
        this.userName = userName;
        
        
    }
    public double getTotalPrice() {
        double total = 0;
        for (OrderProductEntity orderProduct : orderProducts) {
            
            total += orderProduct.getProduct().getPrice() * orderProduct.getQuantity();
        };
        return total;
    }


    public Long getId() {
        return id;
    }
    public Long setId(Long id) {
        return this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
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
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<OrderProductEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProductEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
