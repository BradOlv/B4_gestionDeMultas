package org.los_buenos.gestionMultas.dominio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record PagosDto(

        @PositiveOrZero
        Integer idPago,

        @NotNull(message = "La fecha de pago es obligatoria")
        LocalDate fechaPago,

        @NotNull(message = "El monto pagado es obligatorio")
        @PositiveOrZero(message = "El monto pagado no puede ser negativo")
        Double montoPagado,

        @NotNull(message = "El método de pago es obligatorio")
        String metodoPago,

        @NotNull(message = "La multa asociada es obligatoria")
        @Positive(message = "El ID de la multa debe ser un número positivo")
        Integer idMulta
) {
}