package com.springboot.demoposs.dto.paginated;

import com.springboot.demoposs.dto.response.ResponseOrderDetailsDTO;

import java.util.List;

public class PaginatedResponseOrderDetailsDTO {



    public List<ResponseOrderDetailsDTO> getList() {
        return list;
    }

    public void setList(List<ResponseOrderDetailsDTO> list) {
        this.list = list;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public PaginatedResponseOrderDetailsDTO(List<ResponseOrderDetailsDTO> list, long dataCount) {
        this.list = list;
        this.dataCount = dataCount;
    }

    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
