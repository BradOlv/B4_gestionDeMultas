package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectoresDto{

        @PositiveOrZero
        Integer idInspector;
        @NotBlank(message = "El nombre es obligatorio")
        String nombreInspector;
        @NotBlank (message = "El numero de placa es obligatorio")
        String numeroPlaca;
}
