package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.Evento;
import com.example.barros_proyect.repository.EventoRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EventoService extends BaseService<Evento, Integer, EventoRepository> {

    @Autowired
    EventoRepository eventoRepository;

    public Evento addEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    public Page<Evento> getAll(Pageable pageable, @SearchSpec Specification<Evento> specs){
        return eventoRepository.findAll(specs,pageable);
    }

    public Evento editEvento(Integer id , Evento evento) throws Exception {
        if(eventoRepository.findById(id) != null){
            eventoRepository.delete(eventoRepository.getById(id));
            return eventoRepository.save(evento);
        }
        else{
            throw new Exception("ID erroneo.");
        }
    }

    public String deleteEvento(Integer id){
        if(eventoRepository.findById(id) != null){
            eventoRepository.deleteById(id);
            return "Evento: "+ id +" borrado con éxito.";
        }
        return "ID erroneo.";
    }

    public Evento getEvento(Integer id) throws Exception {
        if(eventoRepository.findById(id) != null){
            return eventoRepository.getById(id);
        }else{
            throw new Exception("ID erroneo");
        }
    }
}