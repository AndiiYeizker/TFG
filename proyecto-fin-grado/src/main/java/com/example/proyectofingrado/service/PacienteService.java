package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteService  {
    void guardarPaciente(PacienteDTO pacienteDTO);
}
