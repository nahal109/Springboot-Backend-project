package com.springboot.demoposs.dto.paginated;

import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import lombok.*;

import java.util.List;





public class PaginatedResponseItemDTO {

    public List<ItemGetResponseDTO> getList() {
        return list;
    }

    public void setList(List<ItemGetResponseDTO> list) {
        this.list = list;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public PaginatedResponseItemDTO(List<ItemGetResponseDTO> list, long dataCount) {
        this.list = list;
        this.dataCount = dataCount;
    }


    List<ItemGetResponseDTO> list;
    private long dataCount;
}
