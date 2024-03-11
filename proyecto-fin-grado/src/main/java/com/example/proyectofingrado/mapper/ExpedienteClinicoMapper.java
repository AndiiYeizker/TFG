package com.example.proyectofingrado.mapper;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;

public class ExpedienteClinicoMapper {


    public static ExpedienteClinicoDTO toExpedienteClinicoDTO(ExpedienteClinico expedienteClinico) {
        ExpedienteClinicoDTO dto = new ExpedienteClinicoDTO();
        dto.setIdPaciente(expedienteClinico.getPaciente());
        dto.setEnfermedad(expedienteClinico.getEnfermedad());
        dto.setFechaInicioSintomas(expedienteClinico.getFechaInicioSintomas());
        return dto;
    }

    public static ExpedienteClinico toExpedienteClinico(ExpedienteClinicoDTO dto) {
        ExpedienteClinico expedienteClinico = new ExpedienteClinico();
        expedienteClinico.setPaciente(dto.getIdPaciente());
        expedienteClinico.setEnfermedad(dto.getEnfermedad());
        expedienteClinico.setFechaInicioSintomas(dto.getFechaInicioSintomas());
        return expedienteClinico;
    }

}
