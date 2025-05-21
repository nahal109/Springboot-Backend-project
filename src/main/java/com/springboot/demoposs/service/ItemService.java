package com.springboot.demoposs.service;

import com.springboot.demoposs.dto.paginated.PaginatedResponseItemDTO;
import com.springboot.demoposs.dto.request.ItemSaveRequestDTO;
import com.springboot.demoposs.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getAllItemByName(String itemName);

    List<ItemGetResponseDTO> getAllItemByActiveState(boolean activeState);

    PaginatedResponseItemDTO getItemByNameActiveStatesWithPaginated(boolean activeState, int page, int size);


    PaginatedResponseItemDTO getAllItemsWithPaginated(int page, int size);
}
