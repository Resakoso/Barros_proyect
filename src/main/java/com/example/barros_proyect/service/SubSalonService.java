package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.SubSalon;
import com.example.barros_proyect.repository.SubSalonRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SubSalonService {

    @Autowired
    SubSalonRepository subSalonRepository;

    public SubSalon addSubSalon(SubSalon subSalon){
        return subSalonRepository.save(subSalon);
    }

    public Page<SubSalon> getAll(Pageable pageable, @SearchSpec Specification<SubSalon> specs){
        return subSalonRepository.findAll(specs, pageable);
    }

    public SubSalon editSubSalon(Integer id , SubSalon subSalon) throws Exception {
        if(subSalonRepository.findById(id) != null){
            subSalonRepository.delete(subSalonRepository.getById(id));
            return subSalonRepository.save(subSalon);
        }
        else{
            throw new Exception("ID erroneo");
        }
    }

    public String deleteSubSalon(Integer id){
        if(subSalonRepository.findById(id) != null){
            subSalonRepository.deleteById(id);
            return "Subsalon:"+ id +" borrado con éxito.";
        }
        return "ID erroneo.";
    }

    public SubSalon getSubsalon(Integer id) throws Exception {
        if(subSalonRepository.findById(id) != null){
            return subSalonRepository.getById(id);
        }else{
            throw new Exception("ID erroneo");
        }
    }
}
