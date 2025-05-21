package com.springboot.demoposs.dto.request;

import com.springboot.demoposs.entity.Item;
import com.springboot.demoposs.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class OrderDetailsSaveDTO {

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }


    public OrderDetailsSaveDTO(String itemName, double qty, double amount, int items, int orders) {
        this.itemName = itemName;
        this.qty = qty;
        this.amount = amount;
        this.items = items;

    }

    public OrderDetailsSaveDTO() {
    }

    private String itemName;
    private double qty;
    private double amount;
    private int items;

}
