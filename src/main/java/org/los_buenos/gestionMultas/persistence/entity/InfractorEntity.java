package org.los_buenos.gestionMultas.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Infractores")
@Data
public class InfractorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInfractor")
    private Integer idInfractor;
    @Column(name="nombreInfractor")
    private String nombreInfractor;
    private Integer dni;
    private String direccion;
    private String email;
}