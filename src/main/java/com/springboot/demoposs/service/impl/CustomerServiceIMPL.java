package com.springboot.demoposs.service.impl;

import com.springboot.demoposs.dto.CustomerDTO;
import com.springboot.demoposs.dto.request.CustomerUpdateDTO;
import com.springboot.demoposs.entity.Customer;
import com.springboot.demoposs.exception.NotFoundException;
import com.springboot.demoposs.repo.CustomerRepo;
import com.springboot.demoposs.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);

            return customerUpdateDTO.getCustomerName();
        } else {
            throw new NotFoundException("Customer not found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getById(customerId);
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
            return customerDTO;
        } else {
            throw new NotFoundException("Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getAllCustomer = customerRepo.findAll();
        if(getAllCustomer.size()>0) {
            List<CustomerDTO> customerDTOList = modelMapper.map(getAllCustomer,new TypeToken<List<CustomerDTO>>(){}.getType());
            return customerDTOList;
        }else {
            throw new NotFoundException("Customer not found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return customerId + "";
        } else {
            throw new NotFoundException("not have cudtomer this id ");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomerByActiveState(boolean activeState) {
        List<Customer> getAllCustomer = customerRepo.findAllByActiveStateEquals(activeState);
        List<CustomerDTO> customerDTOList = modelMapper.map(getAllCustomer,new TypeToken<List<CustomerDTO>>(){}.getType());
        return customerDTOList;
    }
}
