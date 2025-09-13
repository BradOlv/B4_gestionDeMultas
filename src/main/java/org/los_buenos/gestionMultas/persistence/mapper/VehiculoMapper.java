package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.dto.VehiculoDto;
import org.los_buenos.gestionMultas.persistence.entity.VehiculoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehiculoMapper {
    @Mapping(source = "idVehiculo", target = "idVehiculo")
    @Mapping(source = "matricula", target = "matricula")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "modelo", target = "modelo")
    VehiculoDto toDto(VehiculoEntity entity);
    List<VehiculoDto> toDto(Iterable<VehiculoEntity> entities);
    @InheritInverseConfiguration
    VehiculoEntity toEntity(VehiculoDto dto);
}