package org.los_buenos.gestionMultas.dominio.exception;

public class Pagos extends RuntimeException {
    //Pago no realizado
    public Pagos(Long codigo) {
        super("El pago de la multa con codigo " + codigo + " no se ha realizado");
    }
    //Pago ya realizado
    public Pagos(String mensaje) {
        super("El pago de la multa se ha realizado con exito" + mensaje);
    }
}
