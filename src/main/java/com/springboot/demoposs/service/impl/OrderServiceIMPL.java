package com.springboot.demoposs.service.impl;

import com.springboot.demoposs.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.springboot.demoposs.dto.queryinterface.OrderDetailsInterface;
import com.springboot.demoposs.dto.request.OrderSaveDTO;
import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import com.springboot.demoposs.dto.response.ResponseOrderDetailsDTO;
import com.springboot.demoposs.entity.Order;
import com.springboot.demoposs.entity.OrderDetails;
import com.springboot.demoposs.repo.CustomerRepo;
import com.springboot.demoposs.repo.ItemRepo;
import com.springboot.demoposs.repo.OrderDetailsRepo;
import com.springboot.demoposs.repo.OrderRepo;
import com.springboot.demoposs.service.OrderService;
import com.springboot.demoposs.utill.mappers.ItemMapper;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo ;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(OrderSaveDTO orderSaveDTO) {
        Order order = new Order(
                customerRepo.getById(orderSaveDTO.getCustomer()),
                orderSaveDTO.getOrderDate(),
                orderSaveDTO.getTotal()
        );
        orderRepo.save(order);
        if(orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.
                    map(orderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){
                    }.getType());
            for(int i = 0 ; i < orderDetails.size() ; i++) {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(orderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size() > 0) {
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "order saved";
        }
        return null;
    }

    @Override
    public PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailsInterface> orderDetailsInterface = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));
        System.out.println(orderDetailsInterface.get(0).getCustomerName());
        List<ResponseOrderDetailsDTO> list = new ArrayList<>();
        for (OrderDetailsInterface o : orderDetailsInterface) {
            ResponseOrderDetailsDTO r = new ResponseOrderDetailsDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getOrderDate(),
                    o.getTotal()
            );
            list.add(r);
        }
        PaginatedResponseOrderDetailsDTO paginatedResponseOrderDetailsDTO = new PaginatedResponseOrderDetailsDTO(
                list,
                orderRepo.countAllOrderDetails(status)
        );
        return paginatedResponseOrderDetailsDTO;
    }
}
