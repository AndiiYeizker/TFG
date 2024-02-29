package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.dtoPeticiones.UsuarioDTO;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.entity.Role;
import com.example.proyectofingrado.entity.User;
import com.example.proyectofingrado.repository.PacienteRepository;
import com.example.proyectofingrado.repository.UserRepository;
import com.example.proyectofingrado.service.PacienteService;

import java.util.Arrays;

public class PacienteServiceImpl implements PacienteService {

    private PacienteRepository pacienteRepository;
    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellidos(pacienteDTO.getApellidos());
        paciente.setEdad(pacienteDTO.getEdad());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setPeso(pacienteDTO.getPeso());
        paciente.setAltura(pacienteDTO.getAltura());

       pacienteRepository.save(paciente);

    }

}
