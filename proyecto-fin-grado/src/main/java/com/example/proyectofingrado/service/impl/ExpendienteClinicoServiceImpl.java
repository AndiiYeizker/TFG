package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.mapper.PacienteMapper;
import com.example.proyectofingrado.repository.ExpedienteClinicoRepository;
import com.example.proyectofingrado.repository.PacienteRepository;
import com.example.proyectofingrado.service.ExpedienteClinicoService;
import com.example.proyectofingrado.mapper.ExpedienteClinicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpendienteClinicoServiceImpl implements ExpedienteClinicoService{

    @Autowired
    ExpedienteClinicoRepository expedienteClinicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;



    @Override
    public void guardarExpedienteClinico(int idPaciente, ExpedienteClinicoDTO expedienteClinicoDTO) {
        Paciente paciente = pacienteRepository.findById((long) idPaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        expedienteClinicoDTO.setIdPaciente(paciente);
        ExpedienteClinico expedienteClinico = ExpedienteClinicoMapper.toExpedienteClinico(expedienteClinicoDTO);
        expedienteClinicoRepository.save(expedienteClinico);
    }

    @Override
    public List<ExpedienteClinicoDTO> obtenerExpedienteClinicosPorPaciente(int idPaciente) {
        Paciente paciente = pacienteRepository.findById((long) idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        List<ExpedienteClinico> expedienteClinicoList = expedienteClinicoRepository.findByPaciente(paciente);
        List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoList.stream().map((expedienteClinico) -> ExpedienteClinicoMapper.toExpedienteClinicoDTO(expedienteClinico))
                .collect(Collectors.toList());
        return expedienteClinicoDTOList;
    }


    @Override
    public ExpedienteClinicoDTO getExpedienteClinicoById(int idExpedienteClinico) {
        ExpedienteClinico expedienteClinico = expedienteClinicoRepository.findById((long) idExpedienteClinico).orElseThrow(() -> new RuntimeException("Expediente clínico no encontrado"));
        ExpedienteClinicoDTO expedienteClinicoDTO = ExpedienteClinicoMapper.toExpedienteClinicoDTO(expedienteClinico);
        return expedienteClinicoDTO;
    }

    @Override
    public void actualizarExpedienteClinico(ExpedienteClinicoDTO expedienteClinicoDTO) {
        expedienteClinicoRepository.save(ExpedienteClinicoMapper.toExpedienteClinico(expedienteClinicoDTO));
    }

    @Override
    public void borrarExpedienteClinico(int idExpedienteClinico) {
        expedienteClinicoRepository.deleteById((long) idExpedienteClinico);
    }


    @Override
    public List<ExpedienteClinicoDTO> obtenerExpedientesClinicos() {
        List<ExpedienteClinico> expedienteClinicoList = expedienteClinicoRepository.findAll();
       List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoList.stream().map((expediente) ->
               ExpedienteClinicoMapper.toExpedienteClinicoDTO(expediente)).collect(Collectors.toList());
       return expedienteClinicoDTOList;
    }


}
