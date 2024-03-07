package com.example.proyectofingrado.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String apellidos;

    @Column(nullable = true)
    private int edad;

    //@Column(name = "fechaNacimiento")
    //@Temporal(TemporalType.DATE)
    //private Date fechaNacimiento;
    @Column(nullable = true)
    private double peso;
    @Column(nullable = true)
    private double altura;
    @Column(nullable = true)
    private String sexo;
    private String pais;



}
