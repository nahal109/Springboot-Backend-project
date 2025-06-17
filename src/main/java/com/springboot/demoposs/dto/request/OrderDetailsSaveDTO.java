package com.springboot.demoposs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class OrderDetailsSaveDTO {

    private String itemName;
    private double qty;
    private double amount;
    private int items;

}
