package com.springboot.demoposs.dto.response;

import java.util.Date;

public class ResponseOrderDetailsDTO {


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ResponseOrderDetailsDTO(String customerName, String customerAddress, Date orderDate, double total) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.total = total;
    }

    //customer
    private String customerName;
    private String customerAddress;

    //order
    private Date orderDate;
    private double total;
}
