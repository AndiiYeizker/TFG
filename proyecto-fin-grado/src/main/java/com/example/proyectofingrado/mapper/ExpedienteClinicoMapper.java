package com.example.proyectofingrado.mapper;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;

public class ExpedienteClinicoMapper {


    public static ExpedienteClinicoDTO toExpedienteClinicoDTO(ExpedienteClinico expedienteClinico) {
        ExpedienteClinicoDTO dto = new ExpedienteClinicoDTO();
        dto.setPaciente(expedienteClinico.getPaciente());
        dto.setEnfermedad(expedienteClinico.getEnfermedad());
        dto.setFechaInicioSintomas(expedienteClinico.getFechaInicioSintomas());
        dto.setId(expedienteClinico.getId());
        dto.setAceptadoPaciente(expedienteClinico.isAceptadoPaciente());
        dto.setAceptadoMedico(expedienteClinico.isAceptadoMedico());
        dto.setDiasTotales(expedienteClinico.getDiasTotales());
        dto.setEstadoSEIRD(expedienteClinico.getEstadoSEIRD());
        dto.setDiasInfeccion(expedienteClinico.getDiasInfeccion());
        dto.setDiasIncubacion(expedienteClinico.getDiasIncubacion());
        return dto;
    }

    public static ExpedienteClinico toExpedienteClinico(ExpedienteClinicoDTO dto) {
        ExpedienteClinico expedienteClinico = new ExpedienteClinico();
        expedienteClinico.setPaciente(dto.getPaciente());
        expedienteClinico.setEnfermedad(dto.getEnfermedad());
        expedienteClinico.setFechaInicioSintomas(dto.getFechaInicioSintomas());
        expedienteClinico.setId(dto.getId());
        expedienteClinico.setAceptadoPaciente(dto.isAceptadoPaciente());
        expedienteClinico.setAceptadoMedico(dto.isAceptadoMedico());
        expedienteClinico.setDiasTotales(dto.getDiasTotales());
        expedienteClinico.setEstadoSEIRD(dto.getEstadoSEIRD());
        expedienteClinico.setDiasInfeccion(dto.getDiasInfeccion());
        expedienteClinico.setDiasIncubacion(dto.getDiasIncubacion());
        return expedienteClinico;
    }

}
