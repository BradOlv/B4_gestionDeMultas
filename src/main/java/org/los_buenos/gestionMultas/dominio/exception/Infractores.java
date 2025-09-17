package org.los_buenos.gestionMultas.dominio.exception;

public class Infractores extends RuntimeException {
    //Infractor no existe
    public Infractores(Long codigo) {
        super("El infractor de codigo" + codigo + "no existe");
    }
    //Infractor ya existe
    public Infractores(String dni) {
        super("El infractor con el dni" + dni + "ya existe");
    }
}
