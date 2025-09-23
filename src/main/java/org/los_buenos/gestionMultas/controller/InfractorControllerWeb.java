package org.los_buenos.gestionMultas.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.InfractorDto;
import org.los_buenos.gestionMultas.dominio.service.InfractorService;
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
@Named("infractorControllerWeb")
public class InfractorControllerWeb implements Serializable {

    @Autowired
    InfractorService infractorService;

    private List<InfractorDto> infractores;
    private InfractorDto infractorSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(InfractorControllerWeb.class);

    @PostConstruct
    public void init() {
        cargarInfractores();
    }

    public void cargarInfractores() {
        this.infractores = this.infractorService.obtenerTodo();
        this.infractores.forEach(infractor -> logger.info("Infractor cargado: " + infractor.toString()));
    }

    public void agregarInfractor() {
        this.infractorSeleccionado = new InfractorDto();
    }

    public void guardarInfractor() {
        logger.info("Infractor a guardar: " + this.infractorSeleccionado);
        if (this.infractorSeleccionado.getIdInfractor() == null) {
            this.infractorService.guardar(this.infractorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Infractor agregado exitosamente."));
        } else {
            this.infractorService.guardar(this.infractorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Infractor actualizado exitosamente."));
        }

        cargarInfractores();

        PrimeFaces.current().executeScript("PF('ventanaModalInfractor').hide()");
        PrimeFaces.current().ajax().update("formulario-infractores:mensaje-emergente",
                "formulario-infractores:tabla-infractores");
        this.infractorSeleccionado = null;
    }

    public void eliminarInfractor() {
        logger.info("Infractor a eliminar: " + this.infractorSeleccionado);
        this.infractorService.eliminar(this.infractorSeleccionado.getIdInfractor());
        this.infractorSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Infractor eliminado exitosamente."));

        cargarInfractores();

        PrimeFaces.current().ajax().update("formulario-infractores:mensaje-emergente",
                "formulario-infractores:tabla-infractores");
    }
}