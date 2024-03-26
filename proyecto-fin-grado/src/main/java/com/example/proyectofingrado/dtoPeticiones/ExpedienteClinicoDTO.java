package com.example.proyectofingrado.dtoPeticiones;

import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.entity.t_estadoSEIRD;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    private Enfermedad enfermedad;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date fechaInicioSintomas;
    private t_estadoSEIRD estadoSEIRD;

    private int diasIncubacion;
    private int diasInfeccion;
    private int diasTotales;
    private boolean aceptado;
}
