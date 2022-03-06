package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.SubSalon;
import com.example.barros_proyect.service.SubSalonService;
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
@RequestMapping("/subSalon")
public class SubSalonController {

    @Autowired
    SubSalonService subSalonService;

    @ApiOperation(value = "Mostrar subsalón.", notes = "Función que muestra un subsalón.")
    @GetMapping("/getSalon/{id}")
    public ResponseEntity<SubSalon> getSubSalon(@PathVariable Integer id) throws Exception {

        SubSalon subSalon = subSalonService.getSubsalon(id);
        return new ResponseEntity<>(subSalon,HttpStatus.OK);
    }

    @ApiOperation(value = "Listar subsalones", notes = "Función que lita los subsalones con filtrado y paginación.")
    @GetMapping("/getAll")
    public ResponseEntity<Page<SubSalon>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                 @SearchSpec Specification<SubSalon> specs){

        Page<SubSalon> subSalones = subSalonService.getAll(pageable,specs);
        return new ResponseEntity<>(subSalones, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir subsalon.", notes = "Función que añade nuevos subsalones.")
    @PostMapping("/add")
    public ResponseEntity<SubSalon> addSubSalon(@RequestBody SubSalon subSalon) {

        SubSalon newSubSalon = subSalonService.addSubSalon(subSalon);
        return new ResponseEntity<>(newSubSalon, HttpStatus.OK);
    }

    @ApiOperation(value = "Editar subsalon.", notes = "Función para editar un subsalon.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<SubSalon> editEvento(@PathVariable Integer id, @RequestBody SubSalon newSubSalon) throws Exception {

        SubSalon subSalon = subSalonService.editSubSalon(id,newSubSalon);
        return new ResponseEntity<>(subSalon,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar subsalón.", notes = "Función que elimina un subsalón.")
    @DeleteMapping("/delete/{id}")
    public String deleteSubSalon(@PathVariable Integer id){

        return subSalonService.deleteSubSalon(id);
    }
}