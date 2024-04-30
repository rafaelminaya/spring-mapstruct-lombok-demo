package com.rminaya.mapstructlombokdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDto {
    private String facturaNumero;
    private String facturaFechaEmision;
    private List<FacturaDetalleDto> facturaDetalles;
}
