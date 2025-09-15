package org.los_buenos.gestionMultas.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Departamentos")
@Data
public class DepartamentosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDepartamento")
    private Integer idDepartamento;
    private String nombreDepartamento;
    private String municipio;
    private String direccionOficinas;
}
