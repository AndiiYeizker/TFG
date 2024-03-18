package com.example.proyectofingrado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_estadoSEIRD")
public class t_estadoSEIRD {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    //falta etiqueta de inmutable
    private String codigo;

    /** Estados posibles: susceptible, expuesto, infectado, recuperado, deceso*/
    private String estado;


}
