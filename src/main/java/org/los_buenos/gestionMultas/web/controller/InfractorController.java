package org.los_buenos.gestionMultas.web.controller;

import org.los_buenos.gestionMultas.dominio.dto.InfractorDto;
import org.los_buenos.gestionMultas.dominio.service.InfractorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/infractores")
public class InfractorController {
    private final InfractorService infractorService;

    public InfractorController(InfractorService infractorService) {
        this.infractorService = infractorService;
    }

    @GetMapping
    public ResponseEntity<List<InfractorDto>> obtenerTodos() {
        return new ResponseEntity<>(infractorService.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfractorDto> obtenerInfractorPorId(@PathVariable Integer id) {
        InfractorDto infractor = infractorService.buscarPorId(id);
        return infractor != null ?
                new ResponseEntity<>(infractor, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<InfractorDto> guardarInfractor(@Valid @RequestBody InfractorDto infractorDto) {
        InfractorDto nuevoInfractor = infractorService.guardar(infractorDto);
        return new ResponseEntity<>(nuevoInfractor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfractorDto> actualizarInfractor(@PathVariable Integer id, @Valid @RequestBody InfractorDto infractorDto) {
        InfractorDto infractorExistente = infractorService.buscarPorId(id);
        if (infractorExistente != null) {
            InfractorDto infractorActualizado = infractorService.guardar(new InfractorDto(id, infractorDto.nombreInfractor(), infractorDto.dni(), infractorDto.direccion(), infractorDto.email()));
            return new ResponseEntity<>(infractorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInfractor(@PathVariable Integer id) {
        InfractorDto infractor = infractorService.buscarPorId(id);
        if (infractor != null) {
            infractorService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}