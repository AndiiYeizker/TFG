package com.example.proyectofingrado.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    /**Listas*/
    @OneToMany
    @JoinColumn(name = "idPacienteList")
    private List<ExpedienteClinico> expedienteClinicoList;

    public Paciente(Long id, String nombre, String apellidos, int edad, double peso, double altura, String sexo, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.pais = pais;
    }

}
