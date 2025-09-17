package org.los_buenos.gestionMultas.dominio.exception;

public class Inspectores extends RuntimeException {
    //Inspector no existe
    public Inspectores(Long codigo) {
        super("El inspector con el codigo " + codigo + " no existe");
    }
    //Inspector ya existe
    public Inspectores(String dni) {
        super("El inspector con el dni " + dni + " ya existe");
    }
}
