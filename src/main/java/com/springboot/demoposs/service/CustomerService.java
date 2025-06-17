package com.springboot.demoposs.service;

import com.springboot.demoposs.dto.CustomerDTO;
import com.springboot.demoposs.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomer();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomerByActiveState(boolean activeState);
}
