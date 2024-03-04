package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.dtoPeticiones.UsuarioDTO;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.entity.Role;
import com.example.proyectofingrado.entity.User;
import com.example.proyectofingrado.entity.t_pais;
import com.example.proyectofingrado.mapper.PacienteMapper;
import com.example.proyectofingrado.repository.PacienteRepository;
import com.example.proyectofingrado.repository.UserRepository;
import com.example.proyectofingrado.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellidos(pacienteDTO.getApellidos());
        paciente.setEdad(pacienteDTO.getEdad());
       // paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setPeso(pacienteDTO.getPeso());
        paciente.setAltura(pacienteDTO.getAltura());
        paciente.setSexo(pacienteDTO.getSexo());
        t_pais pais = new t_pais();
        pais.setNombrePais(pacienteDTO.getPais());
        paciente.setT_pais(pais);

       pacienteRepository.save(paciente);
    }

    @Override
    public List<PacienteDTO> obtenerPacientes() {
        List<Paciente> pacienteList = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOList = pacienteList.stream().map((paciente) -> PacienteMapper.maptoPacienteDTO(paciente))
                .collect(Collectors.toList());

        return pacienteDTOList;
    }

}
