package com.springboot.demoposs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ResponseOrderDetailsDTO {

    //customer
    private String customerName;
    private String customerAddress;

    //order
    private Date orderDate;
    private double total;
}
