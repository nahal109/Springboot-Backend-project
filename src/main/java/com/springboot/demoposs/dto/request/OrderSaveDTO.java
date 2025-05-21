package com.springboot.demoposs.dto.request;

import com.springboot.demoposs.entity.Customer;
import com.springboot.demoposs.entity.OrderDetails;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderSaveDTO {
    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public List<OrderDetailsSaveDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsSaveDTO> orderDetails) {
        this.orderDetails = orderDetails;
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

    public OrderSaveDTO(int customer, List<OrderDetailsSaveDTO> orderDetails, double total, Date orderDate) {
        this.customer = customer;
        this.orderDetails = orderDetails;
        this.total = total;
        this.orderDate = orderDate;
    }

    public OrderSaveDTO() {
    }

    private int customer;
    private Date orderDate;
    private double total;
    private List<OrderDetailsSaveDTO> orderDetails;

}
