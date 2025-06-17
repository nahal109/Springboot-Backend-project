package com.springboot.demoposs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balnceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

}
