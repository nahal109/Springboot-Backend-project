package com.springboot.demoposs.contoller;


import com.springboot.demoposs.dto.CustomerDTO;
import com.springboot.demoposs.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.springboot.demoposs.dto.request.OrderSaveDTO;
import com.springboot.demoposs.service.OrderService;
import com.springboot.demoposs.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/order")
@CrossOrigin

public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/add-order")
    public ResponseEntity<StandardResponse> addOrder(@RequestBody OrderSaveDTO orderSaveDTO) {
        String massage = orderService.addOrder(orderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "saved successfully", massage),
                HttpStatus.CREATED
        );
    }
    @GetMapping(
            path = "/get_order_details",
            params = {"stateType","page","size"}
    )
    public ResponseEntity<StandardResponse> getOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        PaginatedResponseOrderDetailsDTO p = null;
        if (stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")) {
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            p = orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "saved successfully", p),
                HttpStatus.CREATED
        );
    }
}
