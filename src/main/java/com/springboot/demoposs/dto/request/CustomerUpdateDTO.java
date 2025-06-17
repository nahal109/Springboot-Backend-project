package com.springboot.demoposs.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class CustomerUpdateDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;

}
