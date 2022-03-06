package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Usuario;
import com.example.barros_proyect.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @ApiOperation(value = "Mostrar usuario.", notes = "Función para mostrar un usuario.")
    @GetMapping("/getUsuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) throws Exception {
        Usuario usuario = usuarioService.getUsuario(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }

    @ApiOperation(value = "Listar usuarios", notes = "Función para listar usuarios.")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Usuario>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                                @SearchSpec Specification<Usuario> specs){
        Page<Usuario> usuarios = usuarioService.getAll(pageable,specs);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir usuario.", notes = "Función que añade un usuario nuevo.")
    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.OK);
    }

    @ApiOperation(value = "Editar usuario.", notes = "Funciñon para editar usuarios.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<Usuario> editUsuario(@PathVariable Integer id, @RequestBody Usuario newUsuario) throws Exception {
        Usuario addedUsuario = usuarioService.editUsuario(id,newUsuario);
        return new ResponseEntity<>(addedUsuario,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar usuario.", notes = "Función que elimina usuarios.")
    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        return usuarioService.deleteUsuario(id);
    }
}