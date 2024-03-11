package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.mapper.PacienteMapper;
import com.example.proyectofingrado.repository.PacienteRepository;
import com.example.proyectofingrado.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
       Paciente paciente = PacienteMapper.maptoPaciente(pacienteDTO);
       pacienteRepository.save(paciente);
    }

    @Override
    public List<PacienteDTO> obtenerPacientes() {
        List<Paciente> pacienteList = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOList = pacienteList.stream().map((paciente) -> PacienteMapper.maptoPacienteDTO(paciente))
                .collect(Collectors.toList());

        return pacienteDTOList;
    }

    @Override
    public PacienteDTO getPacienteById(int idPaciente) {
       Paciente paciente = pacienteRepository.findById(idPaciente);
       PacienteDTO pacienteDTO = PacienteMapper.maptoPacienteDTO(paciente);
       return pacienteDTO;
    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        pacienteRepository.save(PacienteMapper.maptoPaciente(pacienteDTO));
    }

    @Override
    public void borrarPaciente(int idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }


}
