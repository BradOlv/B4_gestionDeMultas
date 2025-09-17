package org.los_buenos.gestionMultas.dominio.exception;

public class Vehiculos extends RuntimeException {
  //Vehiculo no existe
  public Vehiculos(Long codigo) {
    super("El vehiculo con el codigo" + codigo + "no existe");
  }

  //Vehiculo ya existe
  public Vehiculos(String matricula){
    super("El vehiculo con la matricula" + matricula + "ya existe");
  }
}
