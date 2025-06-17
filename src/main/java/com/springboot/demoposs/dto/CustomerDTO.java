package com.springboot.demoposs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String nic;
    private boolean activeState;
}
