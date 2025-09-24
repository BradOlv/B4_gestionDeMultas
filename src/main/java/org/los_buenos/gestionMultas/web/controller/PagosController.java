package org.los_buenos.gestionMultas.web.controller;

import jakarta.validation.Valid;
import org.los_buenos.gestionMultas.dominio.dto.PagosDto;
import org.los_buenos.gestionMultas.dominio.service.PagosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pagos")
public class PagosController {
    private final PagosService pagosService;

    public PagosController(PagosService pagosService) {
        this.pagosService = pagosService;
    }

    @GetMapping
    public ResponseEntity<List<PagosDto>> obtenerTodos(){
        return new ResponseEntity<>(pagosService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagosDto> obtenerPagoPorId(@PathVariable Integer id){
        PagosDto pago = pagosService.buscarPorId(id);
        return pago != null ?
                new ResponseEntity<>(pago, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PagosDto> guardarPago(@RequestBody @Valid PagosDto pagosDto){
        PagosDto nuevoPago = pagosService.guardar(pagosDto);
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagosDto> actualizarPago(@PathVariable Integer id, @Valid @RequestBody PagosDto pagosDto){
        PagosDto pagoExistente = pagosService.buscarPorId(id);
        if(pagoExistente != null){
            PagosDto pagoActualizado = pagosService.guardar(new PagosDto(id, pagosDto.getFechaPago(), pagosDto.getMontoPagado(), pagosDto.getMetodoPago(), pagosDto.getIdMulta()));
            return new ResponseEntity<>(pagoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagosDto> eliminarPago(@PathVariable Integer id){
        PagosDto pago = pagosService.buscarPorId(id);
        if(pago != null){
            pagosService.eliminar(id);
            return new ResponseEntity<>(pago, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}