package com.springboot.demoposs.utill.mappers;

import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import com.springboot.demoposs.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T15:50:07+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public List<ItemGetResponseDTO> ListDTOToPage(Page<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>();
        for ( Item item : items ) {
            list.add( itemToItemGetResponseDTO( item ) );
        }

        return list;
    }

    protected ItemGetResponseDTO itemToItemGetResponseDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        itemGetResponseDTO.setItemId( item.getItemId() );
        itemGetResponseDTO.setItemName( item.getItemName() );
        itemGetResponseDTO.setBalnceQty( item.getBalnceQty() );
        itemGetResponseDTO.setSupplierPrice( item.getSupplierPrice() );
        itemGetResponseDTO.setSellingPrice( item.getSellingPrice() );
        itemGetResponseDTO.setActiveState( item.isActiveState() );

        return itemGetResponseDTO;
    }
}
