package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.dto.InfractorDto;
import org.los_buenos.gestionMultas.persistence.entity.InfractorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InfractorMapper {
    @Mapping(source = "idInfractor", target = "idInfractor")
    @Mapping(source = "nombreInfractor", target = "nombreInfractor")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "email", target = "email")
    InfractorDto toDto(InfractorEntity entity);
    List<InfractorDto> toDto(Iterable<InfractorEntity> entities);
    @InheritInverseConfiguration
    InfractorEntity toEntity(InfractorDto dto);
}