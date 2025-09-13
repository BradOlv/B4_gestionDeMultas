package org.los_buenos.gestionMultas.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Vehiculos")
@Data
public class VehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVehiculo")
    private Integer idVehiculo;
    private String matricula;
    private String marca;
    private String modelo;
}