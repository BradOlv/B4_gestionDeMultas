package org.los_buenos.gestionMultas.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.InspectoresDto;
import org.los_buenos.gestionMultas.dominio.service.InspectoresService;
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
@Named("inspectoresControllerWeb")
public class InspectoresControllerWeb implements Serializable {

    @Autowired
    private InspectoresService inspectoresService;

    private List<InspectoresDto> inspectores;
    private InspectoresDto inspectorSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(InspectoresControllerWeb.class);

    @PostConstruct
    public void init() {
        cargarInspectores();
    }

    public void cargarInspectores() {
        this.inspectores = inspectoresService.obtenertodo();
        this.inspectores.forEach(inspector -> logger.info("Inspector cargado: " + inspector));
    }

    public void agregarInspector() {
        this.inspectorSeleccionado = new InspectoresDto();
    }

    public void guardarInspector() {
        logger.info("Inspector a guardar: " + this.inspectorSeleccionado);
        if (this.inspectorSeleccionado.getIdInspector() == null) {
            inspectoresService.guardar(this.inspectorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Inspector agregado exitosamente."));
        } else {
            inspectoresService.guardar(this.inspectorSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Inspector actualizado exitosamente."));
        }

        cargarInspectores();
        PrimeFaces.current().ajax().update("formulario-inspectores:tabla-inspectores", "formulario-inspectores:mensaje-emergente");
        PrimeFaces.current().executeScript("PF('ventanaModalInspector').hide()");
    }

    public void eliminarInspector() {
        logger.info("Inspector a eliminar: " + this.inspectorSeleccionado);
        inspectoresService.eliminar(this.inspectorSeleccionado.getIdInspector());
        this.inspectorSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Inspector eliminado exitosamente."));

        cargarInspectores();
        PrimeFaces.current().ajax().update("formulario-inspectores:tabla-inspectores", "formulario-inspectores:mensaje-emergente");
    }
}