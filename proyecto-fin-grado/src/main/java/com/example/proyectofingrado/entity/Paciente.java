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
    private String id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private double altura;


    @Column(nullable = false)
    private String sexo;

    @ManyToOne
    private t_pais t_pais;

    public Paciente(String nombre, String apellidos, int edad, double peso, double altura, String sexo) {
    }
}
