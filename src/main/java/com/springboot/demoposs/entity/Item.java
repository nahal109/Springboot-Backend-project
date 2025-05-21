package com.springboot.demoposs.entity;

import com.springboot.demoposs.entity.enums.MesuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;


@Entity
@Table(name = "item")

public class Item {
    @Id
    @Column(name = "item_id",length=10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length=200,nullable=false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length=100,nullable=false)
    private MesuringUnitType mesuringUnitType;

    @Column(name = "balnce_qty",length=100,nullable=false)
    private double balnceQty;

    @Column(name = "supplier_price",length=100,nullable=false)
    private double supplierPrice;

    @Column(name = "selling_price",length=100,nullable=false)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState = true;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;

    public Item() {
    }

    public Item(int itemId, String itemName, MesuringUnitType mesuringUnitType, double balnceQty, double supplierPrice, double sellingPrice, boolean activeState) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.mesuringUnitType = mesuringUnitType;
        this.balnceQty = balnceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", mesuringUnitType=" + mesuringUnitType +
                ", balnceQty=" + balnceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeState=" + activeState +
                '}';
    }
}
