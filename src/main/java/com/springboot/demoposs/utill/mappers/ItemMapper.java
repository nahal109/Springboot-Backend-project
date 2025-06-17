package com.springboot.demoposs.utill.mappers;


import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import com.springboot.demoposs.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ItemMapper {
    List<ItemGetResponseDTO>ListDTOToPage(Page<Item> items);
}
