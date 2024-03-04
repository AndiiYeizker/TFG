package com.example.proyectofingrado.mapper;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.Paciente;

public class PacienteMapper {

    public static PacienteDTO maptoPacienteDTO(Paciente paciente){
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNombre(), paciente.getApellidos(), paciente.getFechaNacimiento(),
                paciente.getEdad(), paciente.getPeso(),paciente.getAltura(),paciente.getSexo(),paciente.getT_pais());

        return pacienteDTO;
    }

    public static Paciente maptoPaciente(PacienteDTO pacienteDTO){

        Paciente paciente = new Paciente(pacienteDTO.getNombre(), pacienteDTO.getApellidos(),pacienteDTO.getFechaNacimiento(),
                pacienteDTO.getEdad(), pacienteDTO.getPeso(),pacienteDTO.getAltura(),pacienteDTO.getSexo(),pacienteDTO.getPais());

        return paciente;
    }
}
