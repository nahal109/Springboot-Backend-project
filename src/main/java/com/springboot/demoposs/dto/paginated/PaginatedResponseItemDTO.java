package com.springboot.demoposs.dto.paginated;

import com.springboot.demoposs.dto.response.ItemGetResponseDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaginatedResponseItemDTO {

    List<ItemGetResponseDTO> list;
    private long dataCount;
}
