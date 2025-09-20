package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.dto.MultasDto;
import org.los_buenos.gestionMultas.persistence.entity.MultasEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StateMapper.class})
public interface MultasMapper {
    @Mapping(source = "idMulta", target = "idMulta")
    @Mapping(source = "monto", target = "monto")
    @Mapping(source = "fechaInfraccion", target = "fechaInfraccion")
    @Mapping(source = "descripcionMulta", target = "descripcionMulta")
    @Mapping(source = "estado", target = "state", qualifiedByName = "generarState")
    @Mapping(source = "infractor.idInfractor", target = "idInfractor")
    @Mapping(source = "inspector.idInspector", target = "idInspector")
    @Mapping(source = "departamento.idDepartamento", target = "idDepartamento")
    @Mapping(source = "vehiculo.idVehiculo", target = "idVehiculo")
    MultasDto toDto(MultasEntity entity);

    List<MultasDto> toDto(Iterable<MultasEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "state", target = "estado", qualifiedByName = "generarEstado")

    MultasEntity toEntity(MultasDto dto);
}

