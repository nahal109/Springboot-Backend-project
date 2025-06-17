package com.springboot.demoposs.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table

public class OrderSaveDTO {
    private int customer;
    private Date orderDate;
    private double total;
    private List<OrderDetailsSaveDTO> orderDetails;

}
