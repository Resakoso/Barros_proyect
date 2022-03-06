package com.example.barros_proyect.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SALON")
public class Salon implements Serializable {

    @ApiModelProperty(value = "ID del salon", dataType = "Integer",
            position = 1, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALON")
    private Integer idSalon;

    @ApiModelProperty(value = "Nombre del salon", dataType = "String",
            position = 2, example = "Blanco")
    @NonNull
    @Column(name = "NOMBRE_SALON")
    private String nombreSalon;


    @OneToOne(mappedBy = "salon")
    private SubSalon subSalon;

}
