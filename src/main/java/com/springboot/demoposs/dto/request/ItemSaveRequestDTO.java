package com.springboot.demoposs.dto.request;

import com.springboot.demoposs.entity.enums.MesuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ItemSaveRequestDTO {
    private String itemName;
    private MesuringUnitType mesuringUnitType;
    private double balnceQty;
    private double supplierPrice;
    private double sellingPrice;

    public ItemSaveRequestDTO() {
    }

    public ItemSaveRequestDTO(String itemName, MesuringUnitType mesuringUnitType, double balnceQty, double supplierPrice, double sellingPrice) {
        this.itemName = itemName;
        this.mesuringUnitType = mesuringUnitType;
        this.balnceQty = balnceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MesuringUnitType getMesuringUnitType() {
        return mesuringUnitType;
    }

    public void setMesuringUnitType(MesuringUnitType mesuringUnitType) {
        this.mesuringUnitType = mesuringUnitType;
    }

    public double getBalnceQty() {
        return balnceQty;
    }

    public void setBalnceQty(double balnceQty) {
        this.balnceQty = balnceQty;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "ItemSaveRequestDTO{" +
                "itemName='" + itemName + '\'' +
                ", mesuringUnitType=" + mesuringUnitType +
                ", balnceQty=" + balnceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
