package com.springboot.demoposs.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class StandardResponse {
    private int code;
    private String message;
    private Object data;


}
