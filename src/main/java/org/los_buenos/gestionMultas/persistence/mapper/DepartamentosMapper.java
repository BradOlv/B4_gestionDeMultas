package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.dto.DepartamentosDto;
import org.los_buenos.gestionMultas.persistence.entity.DepartamentosEntity;
import org.los_buenos.gestionMultas.persistence.entity.InfractorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartamentosMapper {
    @Mapping(source = "idDepartamento", target = "idDepartamento")
    @Mapping(source = "nombreDepartamento", target = "nombreDepartamento")
    @Mapping(source = "municipio", target = "municipio")
    @Mapping(source = "direccionOficinas", target = "direccionOficinas")
    DepartamentosDto toDto(DepartamentosEntity entity);
    List<DepartamentosDto> toDto(Iterable<DepartamentosEntity> entities);
    @InheritInverseConfiguration
    DepartamentosEntity toEntity(DepartamentosDto entity);
}
