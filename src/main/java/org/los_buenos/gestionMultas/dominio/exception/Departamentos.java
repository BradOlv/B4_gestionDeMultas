package org.los_buenos.gestionMultas.dominio.exception;

public class Departamentos extends RuntimeException {
    //Departamento no existente
    public Departamentos(Long codigo) {
        super("El departamento con el codigo " + codigo + " no existe");
    }
    //Departamento ya existente
    public Departamentos(String nombre) {
        super("El departamento con el nombre " + nombre + " ya existe");
    }
}
