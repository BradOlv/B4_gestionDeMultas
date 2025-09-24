package org.los_buenos.gestionMultas.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.los_buenos.gestionMultas.dominio.dto.DepartamentosDto;
import org.los_buenos.gestionMultas.dominio.service.DepartamentosService;
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
@Named("departamentosControllerWeb")
public class DepartamentosControllerWeb implements Serializable {
    @Autowired
    DepartamentosService departamentosService;

    private List<DepartamentosDto> departamentos;
    private DepartamentosDto departamentoSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(DepartamentosControllerWeb.class);

    @PostConstruct
    public void init() {cargarDepartamentos();}

    public void cargarDepartamentos() {
        this.departamentos = this.departamentosService.obtenerTodo();
        this.departamentos.forEach(departamento -> logger.info("Departamento cargado: " + departamento.toString()));
    }

    public void agregarDepartamento() {
        this.departamentoSeleccionado = new DepartamentosDto();
    }

    public void guardarDepartamentos() {
        logger.info("Departamento a guardar: " + this.departamentoSeleccionado);
        if (this.departamentoSeleccionado.getIdDepartamento() == null) {
            this.departamentosService.guardar(this.departamentoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Departamento guardado exitosamente"));
        } else {
            this.departamentosService.guardar(this.departamentoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Departamento actualizado exitosamente"));
        }

        cargarDepartamentos();

        PrimeFaces.current().executeScript("PF('venatanaModalDepartamento').hide()");
        PrimeFaces.current().ajax().update("formulario-departamentos:mensaje-emergente",
                "formulario-departamentos:tabla-departamentos");
        this.departamentoSeleccionado = null;
    }

    public void eliminarDepartamentos() {
        logger.info("Departamento a eliminar: " + this.departamentoSeleccionado);
        this.departamentosService.eliminar(this.departamentoSeleccionado.getIdDepartamento());
        this.departamentoSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Departamento eliminado exitosamente"));

        cargarDepartamentos();

        PrimeFaces.current().ajax().update("formulario-departamentos:mensaje-emergente",
                "formulario-departamentos:tabla-departamentos");
    }
}
