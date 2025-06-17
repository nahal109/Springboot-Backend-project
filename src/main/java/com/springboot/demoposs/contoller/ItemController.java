package com.springboot.demoposs.contoller;

import com.springboot.demoposs.dto.paginated.PaginatedResponseItemDTO;
import com.springboot.demoposs.dto.request.ItemSaveRequestDTO;
import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import com.springboot.demoposs.service.ItemService;
import com.springboot.demoposs.utill.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/item-save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String massage = itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "saved successfully", massage),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/item-get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getAllItemByName(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> getAllItem = itemService.getAllItemByName(itemName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "get success", getAllItem),
                HttpStatus.OK
        );
    }

    //paginetion
    @GetMapping(
            path = "/item-get-by-active_state",
            params = {"activeState","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemByNameActiveStatesWithPaginated(
            @RequestParam(value = "activeState") boolean activeState,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(10) int size
            ){

//        List<ItemGetResponseDTO> getAllItem = itemService.getAllItemByActiveState(activeState);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByNameActiveStatesWithPaginated(activeState, page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "get success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    //paginetion
    @GetMapping(
            path = "/get-all-items",
            params = {"page"}
    )
    public ResponseEntity<StandardResponse> getAllItemsWithPaginated(@RequestParam(value = "page") int page){
        int size = 3;
        page = page;
        PaginatedResponseItemDTO getAllItem = itemService.getAllItemsWithPaginated(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, page + " PAGE HAVE GET SUCSESSFULY", getAllItem),
                HttpStatus.OK
        );










    }

}
