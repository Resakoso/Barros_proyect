package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.Usuario;
import com.example.barros_proyect.repository.UsuarioRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario addUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> getAll(Pageable pageable, @SearchSpec Specification<Usuario> specs){
        return usuarioRepository.findAll(specs, pageable);
    }

    public Usuario editUsuario(Integer id , Usuario usuario) throws Exception {
        if(usuarioRepository.findById(id) != null){
            usuarioRepository.delete(usuarioRepository.getById(id));
            return usuarioRepository.save(usuario);
        }
        else{
            throw new Exception("ID erroneo");
        }
    }

    public String deleteUsuario(Integer id){
        if(usuarioRepository.findById(id) != null){
            usuarioRepository.deleteById(id);
            return "Usuario: "+ id +" borrado exitosamente.";
        }
        return "ID erroneo.";
    }

    public Usuario getUsuario(Integer id) throws Exception {
        if(usuarioRepository.findById(id) != null){
            return usuarioRepository.getById(id);
        }else{
            throw new Exception("ID erroneo");
        }
    }
}