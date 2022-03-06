package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Evento;
import com.example.barros_proyect.service.EventoService;
import com.sipios.springsearch.anotation.SearchSpec;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @ApiOperation(value = "Mostrar evento.", notes = "Función para consultar los atributos de un evento.")
    @GetMapping("/getEvento/{id}")
    public ResponseEntity<Evento> getCliente(@PathVariable Integer id) throws Exception {

        Evento evento = eventoService.getEvento(id);
        return new ResponseEntity<>(evento,HttpStatus.OK);
    }

    @ApiOperation(value = "Listar eventos", notes = "Función que lista eventos con paginación y filtrado.")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Evento>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                               @SearchSpec Specification<Evento> specs){

                Page<Evento> eventos = eventoService.getAll(pageable,specs);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir evento.", notes = "Función para añadir nuevos eventos.")
    @PostMapping("/add")
    public ResponseEntity<Evento> addEvento(@RequestBody Evento evento) {

        Evento newEvento = eventoService.addEvento(evento);
        return new ResponseEntity<>(newEvento, HttpStatus.OK);
    }

    @ApiOperation(value = "Editar evento.", notes = "Función que editaa eventos mediante su ID.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Evento> editEvento(@PathVariable Integer id, @RequestBody Evento newEvento) throws Exception {

        Evento evento = eventoService.editEvento(id,newEvento);
        return new ResponseEntity<>(evento,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar evento.", notes = "Función qie elimina un evento.")
    @DeleteMapping("/delete/{id}")
    public String deleteEvento(@PathVariable Integer id){

        return eventoService.deleteEvento(id);
    }
}