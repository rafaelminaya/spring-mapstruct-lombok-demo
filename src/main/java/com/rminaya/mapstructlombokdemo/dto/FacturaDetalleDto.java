package com.rminaya.mapstructlombokdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDetalleDto {
    private Integer cantidad;
    private String precio;
    private String producto;
}
