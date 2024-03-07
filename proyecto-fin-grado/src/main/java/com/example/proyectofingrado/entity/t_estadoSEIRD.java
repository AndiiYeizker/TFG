package com.example.proyectofingrado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_estadoSEIRD")
public class t_estadoSEIRD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //falta etiqueta de inmutable
    private Long codigo;

    /** Estados posibles: susceptible, expuesto, infectado, recuperado, deceso*/
    private String estadoSEIRD;


}
