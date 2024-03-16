package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.dtoRespuestas.EnfermedadDTO;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.mapper.PacienteMapper;

import java.util.List;
import java.util.stream.Collectors;

public interface EnfermedadService {


    void guardarEnfermedad(EnfermedadDTO EnfermedadDTO);

    List<EnfermedadDTO> obtenerEnfermedads();

    EnfermedadDTO getEnfermedadById(Long idEnfermedad);

    void actualizarEnfermedad(EnfermedadDTO EnfermedadDTO);

    void borrarEnfermedad(Long idEnfermedad);

    List<String> obtenerNombresEnfermedades();
}
