package com.rminaya.mapstructlombokdemo.mapper;

import com.rminaya.mapstructlombokdemo.dto.FacturaDto;
import com.rminaya.mapstructlombokdemo.entity.Factura;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FacturaDetalleMapper.class})
public interface FacturaMapper {

    FacturaMapper INSTANCE = Mappers.getMapper(FacturaMapper.class);

    @Mappings({
            @Mapping(target = "facturaNumero", source = "numero"),
            @Mapping(target = "facturaFechaEmision", source = "fechaEmision", dateFormat = "dd/MM/yyyy HH:mm:ss"),
            @Mapping(target = "facturaDetalles", source = "detalles")
    })
    FacturaDto toFacturaDto(Factura factura);

    @InheritInverseConfiguration
    Factura toEntity(FacturaDto facturaDto);

    List<FacturaDto> toFacturaDtoList(List<Factura> factura);

    List<Factura> toEntityList(List<FacturaDto> facturaDto);

}
