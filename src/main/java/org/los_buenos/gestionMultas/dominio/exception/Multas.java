package org.los_buenos.gestionMultas.dominio.exception;

public class Multas extends RuntimeException {
    //Multa no existente
    public Multas(Long codigo) {
        super("La multa del codigo " + codigo + " no existe");
    }
    //Multa ya existente
    public Multas(String placa) {
        super("La multa del vehiculo con placa " + placa + " ya existe");
    }
}
