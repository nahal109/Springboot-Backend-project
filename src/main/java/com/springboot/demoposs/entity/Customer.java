package com.springboot.demoposs.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @Column(name = "customer_id",length=10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",length=200,nullable=false)
    private String customerName;

    @Column(name = "customer_address",length=300)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;
}
