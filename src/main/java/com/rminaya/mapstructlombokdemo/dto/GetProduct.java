package com.rminaya.mapstructlombokdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Esta clase representa un DTO que devolvera un Product en peticiones GETTERS en el controlador
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {

    private Long productId;
    private String productName;
    private String creationDate;
    private GetCategory productCategory;
    private String price;
}
