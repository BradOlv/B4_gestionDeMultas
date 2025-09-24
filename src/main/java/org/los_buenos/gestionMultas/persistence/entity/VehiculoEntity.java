package org.los_buenos.gestionMultas.persistence.entity;
import java.util.List;
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

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MultasEntity> multas;
}