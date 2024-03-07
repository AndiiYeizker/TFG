package com.example.proyectofingrado.mapper;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.Paciente;


public class PacienteMapper {

    public static PacienteDTO maptoPacienteDTO(Paciente paciente){
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getId(),paciente.getNombre(), paciente.getApellidos(),
                 paciente.getFechaNacimiento(),paciente.getEdad(),paciente.getPeso(),paciente.getAltura(),
                paciente.getSexo(), paciente.getPais());

        return pacienteDTO;
    }

    public static Paciente maptoPaciente(PacienteDTO pacienteDTO){

        Paciente paciente = new Paciente(pacienteDTO.getId(),pacienteDTO.getNombre(),pacienteDTO.getApellidos(),
                pacienteDTO.getEdad(),pacienteDTO.getFechaNacimiento(), pacienteDTO.getPeso(),pacienteDTO.getAltura(),pacienteDTO.getSexo(),
                pacienteDTO.getPais());

        return paciente;
    }
}
