package org.los_buenos.gestionMultas.web.controller.exception;

import org.los_buenos.gestionMultas.dominio.exception.Error;
import org.los_buenos.gestionMultas.dominio.exception.Vehiculos;
import org.los_buenos.gestionMultas.dominio.exception.Multas;
import org.los_buenos.gestionMultas.dominio.exception.Infractores;
import org.los_buenos.gestionMultas.dominio.exception.Inspectores;
import org.los_buenos.gestionMultas.dominio.exception.Departamentos;
import org.los_buenos.gestionMultas.dominio.exception.Pagos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(Vehiculos.class)
    public ResponseEntity<Error> handleException(Vehiculos ex) {
        Error error = new Error("Vehiculo error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Multas.class)
    public ResponseEntity<Error> handleException(Multas ex) {
        Error error = new Error("Multa error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Infractores.class)
    public ResponseEntity<Error> handleException(Infractores ex) {
        Error error = new Error("Infractor error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Inspectores.class)
    public ResponseEntity<Error> handleException(Inspectores ex) {
        Error error = new Error("Inspector error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Departamentos.class)
    public ResponseEntity<Error> handleException(Departamentos ex) {
        Error error = new Error("Departamento error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Pagos.class)
    public ResponseEntity<Error> handleException(Pagos ex) {
        Error error = new Error("Pago error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleExceptions(MethodArgumentNotValidException ex) {
        List<Error> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errores.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception ex){
        Error error = new Error("Error desconocido", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
