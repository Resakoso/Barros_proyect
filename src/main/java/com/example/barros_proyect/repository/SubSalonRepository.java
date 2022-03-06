package com.example.barros_proyect.repository;

import com.example.barros_proyect.domain.SubSalon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SubSalonRepository extends JpaRepository<SubSalon, Integer>, JpaSpecificationExecutor<SubSalon> {
}
