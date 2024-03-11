package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;

import java.util.List;

public interface ExpedienteClinicoService {

    void guardarExpedienteClinico(Long idPaciente, ExpedienteClinicoDTO expedienteClinicoDTO);

    List<ExpedienteClinicoDTO> obtenerExpedienteClinicosPorPaciente(Long idPaciente);

    ExpedienteClinicoDTO getExpedienteClinicoById(Long idExpedienteClinico);

    void actualizarExpedienteClinico(ExpedienteClinicoDTO expedienteClinicoDTO);

    void borrarExpedienteClinico(Long idExpedienteClinico);
}
