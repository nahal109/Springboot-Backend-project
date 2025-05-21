package com.springboot.demoposs.dto.response;

public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balnceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

    public ItemGetResponseDTO() {
    }

    public ItemGetResponseDTO(int itemId, String itemName, double balnceQty, double supplierPrice, double sellingPrice, boolean activeState) {
        this.itemId = itemId;
        this.itemName = itemName;
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
        return "ItemGetResponseDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", balnceQty=" + balnceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeState=" + activeState +
                '}';
    }
}
