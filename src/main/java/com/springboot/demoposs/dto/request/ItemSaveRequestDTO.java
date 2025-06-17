package com.springboot.demoposs.dto.request;

import com.springboot.demoposs.entity.enums.MesuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ItemSaveRequestDTO {
    private String itemName;
    private MesuringUnitType mesuringUnitType;
    private double balnceQty;
    private double supplierPrice;
    private double sellingPrice;

}
