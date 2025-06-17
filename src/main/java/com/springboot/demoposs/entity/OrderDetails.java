package com.springboot.demoposs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders_details")

public class OrderDetails {
    @Id
    @Column(name = "order_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item_name",nullable=false)
    private String itemName;

    @Column(name = "qty",nullable=false)
    private double qty;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;
}
