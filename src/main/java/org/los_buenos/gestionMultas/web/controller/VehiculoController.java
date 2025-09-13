package org.los_buenos.gestionMultas.web.controller;

import org.los_buenos.gestionMultas.dominio.dto.VehiculoDto;
import org.los_buenos.gestionMultas.dominio.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/vehiculos")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDto>> obtenerTodos() {
        return new ResponseEntity<>(vehiculoService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDto> obtenerVehiculoPorId(@PathVariable Integer id) {
        VehiculoDto vehiculo = vehiculoService.buscarPorId(id);
        return vehiculo != null ?
                new ResponseEntity<>(vehiculo, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VehiculoDto> guardarVehiculo(@Valid @RequestBody VehiculoDto vehiculoDto) {
        VehiculoDto nuevoVehiculo = vehiculoService.guardar(vehiculoDto);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDto> actualizarVehiculo(@PathVariable Integer id, @Valid @RequestBody VehiculoDto vehiculoDto) {
        VehiculoDto vehiculoExistente = vehiculoService.buscarPorId(id);
        if (vehiculoExistente != null) {
            VehiculoDto vehiculoActualizado = vehiculoService.guardar(new VehiculoDto(id, vehiculoDto.matricula(), vehiculoDto.marca(), vehiculoDto.modelo()));
            return new ResponseEntity<>(vehiculoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Integer id) {
        VehiculoDto vehiculo = vehiculoService.buscarPorId(id);
        if (vehiculo != null) {
            vehiculoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
