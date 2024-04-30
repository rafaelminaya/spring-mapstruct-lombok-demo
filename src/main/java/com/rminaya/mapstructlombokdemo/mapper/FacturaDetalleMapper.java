package com.rminaya.mapstructlombokdemo.mapper;

import com.rminaya.mapstructlombokdemo.dto.FacturaDetalleDto;
import com.rminaya.mapstructlombokdemo.entity.FacturaDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FacturaDetalleMapper {

    FacturaDetalleMapper INSTANCE = Mappers.getMapper(FacturaDetalleMapper.class);

    FacturaDetalleDto toDto(FacturaDetalle facturaDetalle);

    @Mapping(target = "id", ignore = true)
    FacturaDetalle toEntity(FacturaDetalleDto facturaDetalleDto);

    List<FacturaDetalleDto> toDtoList(List<FacturaDetalle> facturaDetalleList);

    List<FacturaDetalle> toEntityList(List<FacturaDetalleDto> facturaDetalleDtoList);
}
