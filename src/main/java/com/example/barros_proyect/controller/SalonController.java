package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Salon;
import com.example.barros_proyect.service.SalonService;
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

@RestController
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    SalonService salonService;

    @ApiOperation(value = "Mostrar salón.", notes = "Función que muestra los datos de un salón.")
    @GetMapping("/getSalon/{id}")
    public ResponseEntity<Salon> getSalon(@PathVariable Integer id) throws Exception {

        Salon salon = salonService.getSalon(id);
        return new ResponseEntity<>(salon,HttpStatus.OK);
    }

    @ApiOperation(value = "Listar salones", notes = "Funcnión que lista los salones con filtrado y paginación.")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Salon>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                              @SearchSpec Specification<Salon> specs){

        Page<Salon> salones = salonService.getAll(pageable,specs);
        return new ResponseEntity<>(salones, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir salón.", notes = "Función que añade nuevos salones.")
    @PostMapping("/add")
    public ResponseEntity<Salon> addSalon(@RequestBody Salon salon) {

        Salon newSalon = salonService.addSalon(salon);
        return new ResponseEntity<>(newSalon, HttpStatus.OK);
    }

    @ApiOperation(value = "Editar salón.", notes = "Función que editar salone.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Salon> editSalon(@PathVariable Integer id, @RequestBody Salon newSalon) throws Exception {

        Salon salon = salonService.editSalon(id,newSalon);
        return new ResponseEntity<>(salon,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar salón.", notes = "Función que elimina un salón.")
    @DeleteMapping("/delete/{id}")
    public String deleteSalon(@PathVariable Integer id){

        return salonService.deleteSalon(id);
    }
}