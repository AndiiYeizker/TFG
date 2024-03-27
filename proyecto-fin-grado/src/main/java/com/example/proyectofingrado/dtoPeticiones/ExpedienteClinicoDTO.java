package com.example.proyectofingrado.dtoPeticiones;

import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.entity.t_estadoSEIRD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpedienteClinicoDTO {

    private int id;
    private Paciente paciente;
    @ManyToOne(cascade = CascadeType.PERSIST) //para el error de flush the transient instance
    private Enfermedad enfermedad;
    @DateTimeFormat(pattern = "dd-MM-yyyy") //MM = mes mm = minutos
    private Date fechaInicioSintomas;
    private t_estadoSEIRD estadoSEIRD;

    private int diasIncubacion;
    private int diasInfeccion;
    private int diasTotales;
    private boolean aceptadoPaciente;
    private boolean aceptadoMedico;
}
