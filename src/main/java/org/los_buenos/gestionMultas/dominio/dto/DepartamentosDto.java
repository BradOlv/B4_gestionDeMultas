package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentosDto {
    @PositiveOrZero
    Integer idDepartamento;
    @NotBlank(message = "El Nombre es Obligatorio")
    String nombreDepartamento;
    @NotBlank(message = "El Municipio es Obligatorio")
    String municipio;
    @NotBlank(message = "La Dirección es Obligatoria")
    String direccionOficinas;
}


