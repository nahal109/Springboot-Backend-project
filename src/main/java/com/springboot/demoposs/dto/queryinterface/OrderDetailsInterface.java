package com.springboot.demoposs.dto.queryinterface;

import java.util.Date;

public interface OrderDetailsInterface {

    String getCustomerName();

    String getCustomerAddress();

    Date getOrderDate();

    double getTotal();
}
