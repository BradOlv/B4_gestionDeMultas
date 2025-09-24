package org.los_buenos.gestionMultas.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.PagosDto;
import org.los_buenos.gestionMultas.dominio.service.PagosService;
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
@Named("pagosControllerWeb")
public class PagosControllerWeb implements Serializable {

    @Autowired
    PagosService pagosService;

    private List<PagosDto> pagos;
    private PagosDto pagoSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(PagosControllerWeb.class);

    @PostConstruct
    public void init() {
        cargarPagos();
    }

    public void cargarPagos() {
        this.pagos = this.pagosService.obtenerTodo();
        this.pagos.forEach(pagos -> logger.info("Pago cargado: " + pagos.toString()));
    }

    public void agregarPagos() {
        this.pagoSeleccionado = new PagosDto();
    }

    public void guardarPagos() {
        logger.info("Guardar pago: " + this.pagoSeleccionado);
        if (this.pagoSeleccionado.getIdPago() == null) {
            this.pagosService.guardar(this.pagoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Realizado con exito", "Pago agregado"));
        } else {
            this.pagosService.guardar(this.pagoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Pago actualizado"));
        }

        cargarPagos();

        PrimeFaces.current().executeScript("PF('ventanaModalPagos').hide()");
        PrimeFaces.current().ajax().update("formulario-pagos:mensaje-emergente",
                "formulario-pagos:tabla-pagos");
        this.pagoSeleccionado = null;
    }

    public void eliminarPagos() {
        logger.info("Eliminar pago: " + this.pagoSeleccionado);
        this.pagosService.eliminar(this.pagoSeleccionado.getIdPago());
        this.pagoSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Pago eliminado de manera exitosa"));

        cargarPagos();

        PrimeFaces.current().ajax().update("formulario-pagos:mensaje-emergente",
                "formulario-pagos:tabla-pagos");
    }
}