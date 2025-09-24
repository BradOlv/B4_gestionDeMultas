package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.los_buenos.gestionMultas.dominio.State;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultasDto{

        @PositiveOrZero
        Integer idMulta;

        @NotNull(message = "El monto es obligatorio")
        @PositiveOrZero(message = "El monto no puede ser negativo")
        Double monto;

        @NotNull(message = "La fecha de infracción es obligatoria")
        LocalDate fechaInfraccion;

        @NotBlank(message = "La descripción es obligatoria")
        String descripcionMulta;

        State state;

        @NotNull(message = "El infractor es obligatorio")
        Integer idInfractor;

        @NotNull(message = "El inspector es obligatorio")
        Integer idInspector;

        @NotNull(message = "El departamento es obligatorio")
        Integer idDepartamento;

        @NotNull(message = "El vehículo es obligatorio")
        Integer idVehiculo;
}
