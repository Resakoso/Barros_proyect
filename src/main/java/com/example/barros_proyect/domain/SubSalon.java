package com.example.barros_proyect.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "SUB_SALON")
public class SubSalon implements Serializable {

    @ApiModelProperty(value = "ID del subSalon", dataType = "Integer",
            position = 1, example = "1A")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUBSALON")
    private Integer idSubSalon;

    @ApiModelProperty(value = "Nombre del subSalon", dataType = "String",
            position = 2, example = "1B")
    @NonNull
    @Column(name = "NOMBRE_SUBSALON")
    private String nombreSubsalon;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(cascade = CascadeType.ALL)
    private Salon salon;
}
