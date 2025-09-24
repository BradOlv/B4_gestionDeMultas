package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDto{
        @PositiveOrZero
        Integer idVehiculo;
        @NotBlank (message = "La matrícula es obligatoria")
        String matricula;
        @NotBlank (message = "La marca es obligatoria")
        String marca;
        @NotBlank (message = "El modelo es obligatorio")
        String modelo;
}