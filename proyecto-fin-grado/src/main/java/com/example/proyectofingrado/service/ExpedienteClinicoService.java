package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;

import java.util.List;

public interface ExpedienteClinicoService {


    void guardarExpedienteClinico(int idPaciente, ExpedienteClinicoDTO expedienteClinicoDTO);

    List<ExpedienteClinicoDTO> obtenerExpedienteClinicosPorPaciente(int idPaciente);

    ExpedienteClinicoDTO getExpedienteClinicoById(int idExpedienteClinico);

    void actualizarExpedienteClinico(ExpedienteClinicoDTO expedienteClinicoDTO);


    void borrarExpedienteClinico(int idExpedienteClinico);

    List<ExpedienteClinicoDTO> obtenerExpedientesClinicos();
}
