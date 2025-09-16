package org.los_buenos.gestionMultas.persistence.mapper;


import org.los_buenos.gestionMultas.dominio.dto.InspectoresDto;
import org.los_buenos.gestionMultas.persistence.entity.InspectoresEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InspectoresMapper {
    @Mapping(source = "idInspector", target = "idInspector")
    @Mapping(source = "nombreInspector", target = "nombreInspector")
    @Mapping(source = "numeroPlaca", target = "numeroPlaca")
    InspectoresDto toDto (InspectoresEntity entity);
    List<InspectoresDto> toDto(Iterable<InspectoresEntity> entities);
    @InheritInverseConfiguration
    InspectoresEntity toEntity(InspectoresDto dto);
}
