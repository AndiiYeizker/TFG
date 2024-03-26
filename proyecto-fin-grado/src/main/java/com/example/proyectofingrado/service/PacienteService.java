package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteService  {
    void guardarPaciente(PacienteDTO pacienteDTO);

    Paciente obtenerPacientePorId(Long id);

    List<PacienteDTO> obtenerPacientes();

    PacienteDTO getPacienteById(int idPaciente);

    void actualizarPaciente(PacienteDTO pacienteDTO);

    void borrarPaciente(int idPaciente);
}
