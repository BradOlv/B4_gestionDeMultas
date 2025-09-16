package org.los_buenos.gestionMultas.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Inspectores")
@Data
public class InspectoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInspector")
    private Integer idInspector;
    @Column(name = "nombreInspector")
    private String nombreInspector;
    private String numeroPlaca;
}
