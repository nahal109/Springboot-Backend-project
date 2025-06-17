package com.springboot.demoposs.contoller;

import com.springboot.demoposs.dto.CustomerDTO;
import com.springboot.demoposs.dto.request.CustomerUpdateDTO;
import com.springboot.demoposs.service.CustomerService;
import com.springboot.demoposs.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @PostMapping("/save-customer")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String massage = customerService.saveCustomer(customerDTO);
//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"saved successfully",massage ),HttpStatus.CREATED
//        );
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "saved successfully", massage),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/update-customer")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String massage = customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "update successfully", massage),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-customer-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "get successfully", customerDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-customer"
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "get all successfully", allCustomer),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id") int customerId) {
        String massage = customerService.deleteCustomer(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "deleted successfully", massage ),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-customer-by-avtivestate/{state}"
    )
    public ResponseEntity<StandardResponse> getAllCustomerByActiveState(@PathVariable(value = "state") boolean activeState) {
        List<CustomerDTO> allCustomer = customerService.getAllCustomerByActiveState(activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "get all customer by avtivestate ", allCustomer),
                HttpStatus.OK
        );
    }
}
