package com.example.barros_proyect.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "EVENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento implements Serializable {

    @ApiModelProperty(value = "ID del evento", dataType = "Integer",
            position = 1, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO")
    private Integer idEvento;

    @ApiModelProperty(value = "Fecha de Inicio del evento", dataType = "LocalDateTime",
            position = 2, example = "1999-01-01:00:00.00")
    @NonNull
    @Column(name = "FECHA_INICIO")
    private LocalDateTime fechaInicio;

    @ApiModelProperty(value = "Fecha de Fin del evento", dataType = "LocalDateTime",
            position = 3, example = "1999-01-01:00:00.00")
    @NonNull
    @Column(name = "FECHA_FIN")
    private LocalDateTime fechaFin;

    @ApiModelProperty(value = "Comida o Cena del evento", dataType = "String",
            position = 4, example = "Comida")
    @NonNull
    @Column(name = "COMIDA_CENA")
    private String comidaCena;

    @ApiModelProperty(value = "Numero de comensales del evento", dataType = "Integer",
            position = 5, example = "7")
    @NonNull
    @Column(name = "NUMERO_COMENSALES")
    private Integer numeroComensales;

    @ApiModelProperty(value = "Contrado asociado del evento", dataType = "Integer",
            position = 6, example = "143254675")
    @NonNull
    @Column(name = "CONTRATO_ASOCIADO")
    private Integer contratoAsociado;


    @ApiModelProperty(value = "Menu del evento", dataType = "String",
            position = 7, example = "Menu 3")
    @NonNull
    @Column(name = "MENU") //PDF
    private String menu;

    @ApiModelProperty(value = "Menu infantil del evento", dataType = "String",
            position = 8, example = "Menu Infantil")
    @NonNull
    @Column(name = "MENU_INFANTIL") //PDF
    private String menuInfantil;

    @ApiModelProperty(value = "Menu especial del evento", dataType = "String",
            position = 9, example = "Menu Especial")
    @Column(name = "MENU_ESPECIAL")
    private String menuEspecial;

    @ApiModelProperty(value = "Planos del evento", dataType = "String",
            position = 10, example = "Ejemplo Planos")
    @NonNull
    @Column(name = "PLANOS") //PDF
    private String planos;

    @ApiModelProperty(value = "Dj del evento", dataType = "String",
            position = 11, example = "DJ Cano")
    @Column(name = "DJ")
    private String dj;

    @ApiModelProperty(value = "Musica salon del evento", dataType = "String",
            position = 12, example = "Heavy Metal")
    @Column(name = "MUSICA_SALON")
    private String musicaSalon;

    @ApiModelProperty(value = "Musica aperitivo del evento", dataType = "String",
            position = 13, example = "Jazz")
    @Column(name = "MUSICA_APERITIVO")
    private String musicaAperitivo;

    @ApiModelProperty(value = "Musica baile del evento", dataType = "String",
            position = 14, example = "Salsa")
    @Column(name = "MUSICA_BAILE")
    private String musicaBaile;

    @ApiModelProperty(value = "Barra libre del evento", dataType = "String",
            position = 15, example = "Barra libre")
    @Column(name = "BARRA_LIBRE")
    private String barraLibre;

    @ApiModelProperty(value = "Flores del evento", dataType = "String",
            position = 16, example = "Jazmines y claveles")
    @Column(name = "FLORES")
    private String flores;

    @ApiModelProperty(value = "Ceremonia barros del evento", dataType = "Boolean",
            position = 17, example = "False")
    @Column(name = "CEREMONIA_BARROS")
    private Boolean ceremoniaBarros;

    @ApiModelProperty(value = "Autobuses del evento", dataType = "String",
            position = 18, example = "Jimenez")
    @Column(name = "AUTOBUSES")
    private String autobuses;

    @ApiModelProperty(value = "Bono autobus del evento", dataType = "Boolean",
            position = 19, example = "True")
    @Column(name = "BONO_AUTOBUS")
    private Boolean bonoAutobus;

    @ApiModelProperty(value = "Bono hotel del evento", dataType = "Boolean",
            position = 20, example = "False")
    @Column(name = "BONO_HOTEL")
    private Boolean bonoHotel;

    @ApiModelProperty(value = "Vinos del evento", dataType = "String",
            position = 21, example = "De la casa")
    @Column(name = "VINOS")
    private String vinos;

    @ApiModelProperty(value = "Cavas del evento", dataType = "String",
            position = 22, example = "De la casa")
    @Column(name = "CAVA")
    private String cava;

    @ApiModelProperty(value = "Rincones del evento", dataType = "String",
            position = 23, example = "Ejemplo rincones")
    @Column(name = "RINCONES")
    private String rincones;

    @ApiModelProperty(value = "Decoraciones del evento", dataType = "String",
            position = 24, example = "Decoración")
    @Column(name = "DECORACION")
    private String decoracion;

    @ApiModelProperty(value = "Notas del evento", dataType = "String",
            position = 25, example = "Notas")
    @Column(name = "NOTAS")
    private String notas;

    @ApiModelProperty(value = "Tipo del evento", dataType = "String",
            position = 26, example = "Fiesta")
    @Column(name = "TIPO_EVENTO")
    private String tipoEvento;

    @ManyToMany
    private List<Cliente> clientes;

    @ApiModelProperty(value = "SubSalones del evento", dataType = "List<SubSalon>",
            position = 28, example = "2A")
    @JsonIgnore
    @ManyToMany
    private List<SubSalon> subsalones;
}