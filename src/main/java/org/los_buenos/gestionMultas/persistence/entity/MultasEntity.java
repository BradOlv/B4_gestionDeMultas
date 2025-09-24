package org.los_buenos.gestionMultas.persistence.entity;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Multas")
@Data
public class MultasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMulta;

    private Double monto;

    private LocalDate fechaInfraccion;

    private String descripcionMulta;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idInfractor")
    private InfractorEntity infractor;

    @ManyToOne
    @JoinColumn(name = "idInspector")
    private InspectoresEntity inspector;

    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private DepartamentosEntity departamento;

    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    private VehiculoEntity vehiculo;

    @OneToMany(mappedBy = "multa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PagosEntity> pagos;

}

