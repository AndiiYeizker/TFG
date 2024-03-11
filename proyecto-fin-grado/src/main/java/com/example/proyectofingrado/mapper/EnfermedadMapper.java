package com.example.proyectofingrado.mapper;

import com.example.proyectofingrado.dtoRespuestas.EnfermedadDTO;
import com.example.proyectofingrado.entity.Enfermedad;

public class EnfermedadMapper {

    public static Enfermedad toEnfermedad(EnfermedadDTO enfermedadDTO) {
        Enfermedad enfermedad = new Enfermedad();
        enfermedad.setNombre(enfermedadDTO.getNombre());
        enfermedad.setTipoContagio(enfermedadDTO.getTipoContagio());
        enfermedad.setRecomendacion(enfermedadDTO.getRecomendacion());
        enfermedad.setSintomas(enfermedadDTO.getSintomas());
        enfermedad.setVacunasDisponibles(enfermedadDTO.getVacunasDisponibles());
        enfermedad.setTestDeteccion(enfermedadDTO.getTestDeteccion());
        return enfermedad;
    }

    public static EnfermedadDTO toEnfermedadDTO(Enfermedad enfermedad) {
        EnfermedadDTO enfermedadDTO = new EnfermedadDTO();
        enfermedadDTO.setNombre(enfermedad.getNombre());
        enfermedadDTO.setTipoContagio(enfermedad.getTipoContagio());
        enfermedadDTO.setRecomendacion(enfermedadDTO.getRecomendacion());
        enfermedadDTO.setSintomas(enfermedad.getSintomas());
        enfermedadDTO.setVacunasDisponibles(enfermedad.getVacunasDisponibles());
        enfermedadDTO.setTestDeteccion(enfermedad.getTestDeteccion());
        return enfermedadDTO;
    }
}
