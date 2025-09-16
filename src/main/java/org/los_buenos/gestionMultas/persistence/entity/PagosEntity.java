package org.los_buenos.gestionMultas.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Pagos")
@Data
public class PagosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    private LocalDate fechaPago;

    private Double montoPagado;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "idMulta")
    private MultasEntity multa;

    // Enum para el método de pago
    public enum MetodoPago {
        Tarjeta,
        Efectivo,
        Transferencia
    }
}