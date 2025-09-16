package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.dto.PagosDto;
import org.los_buenos.gestionMultas.persistence.entity.PagosEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PagosMapper {

    @Mapping(source = "idPago", target = "idPago")
    @Mapping(source = "fechaPago", target = "fechaPago")
    @Mapping(source = "montoPagado", target = "montoPagado")
    @Mapping(source = "metodoPago", target = "metodoPago")
    @Mapping(source = "multa.idMulta", target = "idMulta")
    PagosDto toDto(PagosEntity entity);

    List<PagosDto> toDto(Iterable<PagosEntity> entities);

    @InheritInverseConfiguration
    PagosEntity toEntity(PagosDto dto);
}