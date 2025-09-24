package org.los_buenos.gestionMultas.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "infractores")
@Data
public class InfractorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infractor")
    private Integer idInfractor;

    @Column(name = "nombre_infractor")
    private String nombreInfractor;

    private Integer dni;

    private String direccion;

    private String email;

    @OneToMany(mappedBy = "infractor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MultasEntity> multas;

}