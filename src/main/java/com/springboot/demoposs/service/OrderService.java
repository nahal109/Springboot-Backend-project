package com.springboot.demoposs.service;

import com.springboot.demoposs.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.springboot.demoposs.dto.request.OrderSaveDTO;

public interface OrderService {
    String addOrder(OrderSaveDTO orderSaveDTO);


    PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size);
}
