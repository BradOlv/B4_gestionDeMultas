package org.los_buenos.gestionMultas.web.controller;

import jakarta.validation.Valid;
import org.los_buenos.gestionMultas.dominio.dto.MultasDto;
import org.los_buenos.gestionMultas.dominio.service.MultasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/multas")
public class MultasController {
    private final MultasService multasService;

    public MultasController(MultasService multasService) {
        this.multasService = multasService;
    }

    @GetMapping
    public ResponseEntity<List<MultasDto>> obtenerTodos(){
        return new ResponseEntity<>(multasService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultasDto> obtenerMultaPorId(@PathVariable Integer id){
        MultasDto multa = multasService.buscarPorId(id);
        return multa != null ?
                new ResponseEntity<>(multa, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MultasDto> guardarMulta(@RequestBody @Valid MultasDto multasDto){
        MultasDto nuevaMulta = multasService.guardar(multasDto);
        return new ResponseEntity<>(nuevaMulta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MultasDto> actualizarMulta(@PathVariable Integer id, @Valid @RequestBody MultasDto multasDto){
        MultasDto multaExistente = multasService.buscarPorId(id);
        if(multaExistente != null){
            MultasDto multaActializada = multasService.guardar(new MultasDto(id, multasDto.getMonto(), multasDto.getFechaInfraccion(), multasDto.getDescripcionMulta(), multasDto.getState(), multasDto.getIdInfractor(), multasDto.getIdInspector(), multasDto.getIdDepartamento(), multasDto.getIdVehiculo()));
            return new ResponseEntity<>(multaActializada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MultasDto> eliminarMulta(@PathVariable Integer id){
        MultasDto multa = multasService.buscarPorId(id);
        if(multa != null){
            multasService.eliminar(id);
            return new ResponseEntity<>(multa, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/por-idvehiculo/{idVehiculo}")
    public ResponseEntity<List<MultasDto>> obtenerMultasPorIdVehiculo(@PathVariable Integer idVehiculo) {
        List<MultasDto> multas = multasService.buscarPorIdVehiculo(idVehiculo);
        if (multas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(multas, HttpStatus.OK);
    }

    @GetMapping("/por-idinfractor/{idInfractor}")
    public ResponseEntity<List<MultasDto>> obtenerMultasPorIdInfractor(@PathVariable Integer idInfractor) {
        List<MultasDto> multas = multasService.buscarPorIdInfractor(idInfractor);
        if (multas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(multas, HttpStatus.OK);
    }
}
