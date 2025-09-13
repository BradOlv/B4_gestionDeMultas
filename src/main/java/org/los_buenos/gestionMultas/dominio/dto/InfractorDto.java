package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record InfractorDto(

        @PositiveOrZero
        Integer idInfractor,
        @NotBlank (message = "El nombre es obligatorio")
        String nombreInfractor,
        @NotNull (message = "El DNI es obligatorio")
        Integer dni,
        @NotBlank (message = "La dirección es obligatoria")
        String direccion,
        @Email (message = "El email debe ser válido")
        String email
) {
}