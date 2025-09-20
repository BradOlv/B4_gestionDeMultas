package org.los_buenos.gestionMultas.persistence.mapper;

import org.los_buenos.gestionMultas.dominio.State;
import org.mapstruct.Named;

public class StateMapper {

    @Named("generarState")
    public static State generarState(String estado) {
        if (estado == null) return null;
        return switch (estado.toUpperCase()){
            case "PENDIENTE" -> State.PENDING;
            case "PAGADA" -> State.PAID;
            case "IMPUGNADA" -> State.CHALLENGED;
            default -> null;
        };
    }

    @Named("generarEstado")
    public static String generarEstado(State state) {
        if (state == null) return null;
        return switch (state){
            case State.PENDING -> "PENDIENTE";
            case  State.PAID -> "PAGADA";
            case State.CHALLENGED -> "IMPUGNADA";
            default -> null;
        };
    }
}
