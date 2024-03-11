package com.example.proyectofingrado.dtoPeticiones;

import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.entity.Paciente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpedienteClinicoDTO {

    private Paciente idPaciente;
    private Enfermedad enfermedad;
    private Date fechaInicioSintomas;
}
