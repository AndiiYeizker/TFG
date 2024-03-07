package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteService  {
    void guardarPaciente(PacienteDTO pacienteDTO);
    List<PacienteDTO> obtenerPacientes();

    PacienteDTO getPacienteById(Long idPaciente);

    void actualizarPaciente(PacienteDTO pacienteDTO);

    void borrarPaciente(Long idPaciente);
}
