package org.los_buenos.gestionMultas.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.los_buenos.gestionMultas.dominio.State;
import org.los_buenos.gestionMultas.dominio.dto.*;
import org.los_buenos.gestionMultas.dominio.service.MultasService;
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
@Named("multasControllerWeb")
public class MultasControllerWeb implements Serializable {
    @Autowired
    MultasService multasService;

    private List<MultasDto> multas;
    private MultasDto multaSeleccionada = new MultasDto();
    private static final Logger logger = LoggerFactory.getLogger(MultasControllerWeb.class);
    private List<InfractorDto> infractores;
    private List<InspectoresDto> inspectores;
    private List<DepartamentosDto> departamentos;
    private List<VehiculoDto> vehiculos;

    @PostConstruct
    public void init() {
        cargarMultas();
        cargarListas(); // <<---- cargamos las listas de entidades relacionadas
        if (this.multaSeleccionada == null) {
            this.multaSeleccionada = new MultasDto();
        }
    }

    private void cargarListas() {
        this.infractores = multasService.obtenerInfractores();
        this.inspectores = multasService.obtenerInspectores();
        this.departamentos = multasService.obtenerDepartamentos();
        this.vehiculos = multasService.obtenerVehiculos();
    }

    public void cargarMultas() {
        this.multas = this.multasService.obtenerTodo();
        this.multas.forEach((multa) -> logger.info("Multa cargada: " + multa.toString()));
    }

    public void agregarMulta() {
        this.multaSeleccionada = new MultasDto();
    }

    public void guardarMultas() {
        logger.info("Multa a guardar: " + this.multaSeleccionada);
        if (this.multaSeleccionada.getIdDepartamento() == null) {
            this.multasService.guardar(this.multaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Multa guardada exitosamente"));
        } else {
            this.multasService.guardar(this.multaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Multa actualizada exitosamente"));
        }

        cargarMultas();

        PrimeFaces.current().executeScript("PF('venatanaModalDepartamento').hide()");
        PrimeFaces.current().ajax().update("formulario-departamentos:mensaje-emergente",
                "formulario-departamentos:tabla-departamentos");
        this.multaSeleccionada = null;
    }

    public void eliminarMulta() {
        logger.info("Multa a eliminar: " + this.multaSeleccionada);
        this.multasService.eliminar(this.multaSeleccionada.getIdMulta());
        this.multaSeleccionada = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Multa eliminada exitosamente"));

        cargarMultas();

        PrimeFaces.current().ajax().update("formulario-multas:mensaje-emergente",
                "formulario-multas:tabla-multas");
    }

    public State[] getEstadosMulta() {
        return State.values();
    }
}
