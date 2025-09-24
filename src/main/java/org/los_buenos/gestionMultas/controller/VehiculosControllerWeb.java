package org.los_buenos.gestionMultas.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.VehiculoDto;
import org.los_buenos.gestionMultas.dominio.service.VehiculoService;
import org.mapstruct.Named;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
@Named("vehiculosControllerWeb")
public class VehiculosControllerWeb implements Serializable {
    @Autowired
    VehiculoService vehiculoService;

    private List<VehiculoDto> vehiculos;
    private VehiculoDto vehiculoSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(VehiculosControllerWeb.class);

    @PostConstruct
    public void init() {
        cargarVehiculos();
    }

    public void cargarVehiculos() {
        this.vehiculos = this.vehiculoService.obtenerTodo();
        this.vehiculos.forEach(vehiculo -> logger.info("Vehículo cargado: " + vehiculo.toString()));
    }

    public void agregarVehiculo() {
        this.vehiculoSeleccionado = new VehiculoDto();
    }

    public void guardarVehiculo() {
        logger.info("Vehículo a guardar: " + this.vehiculoSeleccionado);
        if (this.vehiculoSeleccionado.getIdVehiculo() == null) {
            this.vehiculoService.guardar(this.vehiculoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Vehículo guardado exitosamente"));
        } else {
            this.vehiculoService.guardar(this.vehiculoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Vehículo actualizado exitosamente"));
        }

        cargarVehiculos();

        PrimeFaces.current().executeScript("PF('ventanaModalVehiculo').hide()");
        PrimeFaces.current().ajax().update("formulario-vehiculos:mensaje-emergente",
                "formulario-vehiculos:tabla-vehiculos");
        this.vehiculoSeleccionado = null;
    }

    public void eliminarVehiculo() {
        logger.info("Vehículo a eliminar: " + this.vehiculoSeleccionado);
        this.vehiculoService.eliminar(this.vehiculoSeleccionado.getIdVehiculo());
        this.vehiculoSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Vehículo eliminado exitosamente"));

        cargarVehiculos();

        PrimeFaces.current().ajax().update("formulario-vehiculos:mensaje-emergente",
                "formulario-vehiculos:tabla-vehiculos");
    }
}