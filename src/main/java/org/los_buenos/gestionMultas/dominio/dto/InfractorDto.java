package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfractorDto {

    @PositiveOrZero
    private Integer idInfractor;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombreInfractor;

    @NotNull(message = "El DNI es obligatorio")
    private Integer dni;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @Email(message = "El email debe ser válido")
    private String email;
}