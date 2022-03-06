package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Cliente;
import com.example.barros_proyect.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Listar clientes", notes = "Función que muestra clientes con la paginación y el filtrado.")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Cliente>> getAll(@PageableDefault(size = 10,page = 0)Pageable pageable,
                                                @SearchSpec Specification<Cliente> specs){
        Page<Cliente> clientes = clienteService.getAll(pageable,specs);
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir cliente.", notes = "Función que añade nuevos clientes al sistema.")
    @PostMapping("/add")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {

        Cliente newCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.OK);

    }

    @ApiOperation(value = "Editar clientes.", notes = "Función que edita clientes.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Cliente> editCliente(@PathVariable Integer id, @RequestBody Cliente newCliente) throws Exception {

        Cliente addCliente = clienteService.editCliente(id,newCliente);
        return new ResponseEntity<>(addCliente,HttpStatus.OK);

    }

    @ApiOperation(value = "Eliminar cliente.", notes = "Función que elimina un cliente.")
    @DeleteMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Integer id){

        return clienteService.deleteCliente(id);
    }
}