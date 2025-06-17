package com.springboot.demoposs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")

public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "active_state")
    private boolean activeState = true;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;
}
