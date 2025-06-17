package com.springboot.demoposs.service.impl;

import com.springboot.demoposs.dto.paginated.PaginatedResponseItemDTO;
import com.springboot.demoposs.dto.request.ItemSaveRequestDTO;
import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import com.springboot.demoposs.entity.Item;
import com.springboot.demoposs.exception.NotFoundException;
import com.springboot.demoposs.repo.ItemRepo;
import com.springboot.demoposs.service.ItemService;
import com.springboot.demoposs.utill.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        itemRepo.save(item);
        return itemSaveRequestDTO.getItemName();
    }

    @Override
    public List<ItemGetResponseDTO> getAllItemByName(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEquals(itemName);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOList = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOList;
        } else {
            throw new NotFoundException("not found this item");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getAllItemByActiveState(boolean activeState) {
        List<Item> items = itemRepo.findAllByActiveStateEquals(activeState);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOList = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOList;
        } else {
            throw new NotFoundException("not found this item");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemByNameActiveStatesWithPaginated(boolean activeState, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page,size));
        if(items.isEmpty()){
            throw new NotFoundException("no data in this state");
        }else {
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    itemMapper.ListDTOToPage(items),
                    itemRepo.countAllByActiveStateEquals(activeState)
            );
            return paginatedResponseItemDTO;
        }
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsWithPaginated(int page, int size) {
        int pageCount = (int) (itemRepo.count()/size);
        Page<Item> items = itemRepo.findAllBy(PageRequest.of(page,size));
        if(!items.isEmpty()){
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    itemMapper.ListDTOToPage(items),
                    itemRepo.count()
            );
            return paginatedResponseItemDTO;
        }else {
            throw new NotFoundException("TOTAL PAGE HAVE " + pageCount + " so " + page + " PAGE NOT FOUND");
        }
    }
}
