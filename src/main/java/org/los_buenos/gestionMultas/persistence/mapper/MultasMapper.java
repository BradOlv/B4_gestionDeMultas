package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.dto.MultasDto;
import org.los_buenos.gestionMultas.persistence.entity.MultasEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MultasMapper {
    @Mapping(source = "idMulta", target = "idMulta")
    @Mapping(source = "monto", target = "monto")
    @Mapping(source = "fechaInfraccion", target = "fechaInfraccion")
    @Mapping(source = "descripcionMulta", target = "descripcionMulta")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "infractor.idInfractor", target = "idInfractor")
    @Mapping(source = "departamento.idDepartamento", target = "idDepartamento")
    @Mapping(source = "vehiculo.idVehiculo", target = "idVehiculo")
    MultasDto toDto(MultasEntity entity);

    List<MultasDto> toDto(Iterable<MultasEntity> entities);

    @InheritInverseConfiguration
    MultasEntity toEntity(MultasDto dto);
}

