package com.example.proyectofingrado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_pais")
public class t_pais {

    @Column(nullable = false)
    private String nombrePais;
    @Column(nullable = false)
    private int poblacion;
    @Column(nullable = false)
    private String estado;
}
