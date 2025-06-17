package com.springboot.demoposs.dto.paginated;

import com.springboot.demoposs.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaginatedResponseOrderDetailsDTO {

    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
