package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;
import com.example.proyectofingrado.entity.Paciente;
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

    @Autowired
    ExpedienteClinicoMapper expedienteClinicoMapper;

    @Override
    public void guardarExpedienteClinico(Long idPaciente, ExpedienteClinicoDTO expedienteClinicoDTO) {
        Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        expedienteClinicoDTO.setIdPaciente(paciente);
        ExpedienteClinico expedienteClinico = expedienteClinicoMapper.toExpedienteClinico(expedienteClinicoDTO);
        expedienteClinicoRepository.save(expedienteClinico);
    }

    @Override
    public List<ExpedienteClinicoDTO> obtenerExpedienteClinicosPorPaciente(Long idPaciente) {
        Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        List<ExpedienteClinico> expedienteClinicoList = expedienteClinicoRepository.findByPaciente(paciente);
        List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoList.stream().map((expedienteClinico) -> expedienteClinicoMapper.toExpedienteClinicoDTO(expedienteClinico))
                .collect(Collectors.toList());
        return expedienteClinicoDTOList;
    }

    @Override
    public ExpedienteClinicoDTO getExpedienteClinicoById(Long idExpedienteClinico) {
        ExpedienteClinico expedienteClinico = expedienteClinicoRepository.findById(idExpedienteClinico).orElseThrow(() -> new RuntimeException("Expediente clínico no encontrado"));
        ExpedienteClinicoDTO expedienteClinicoDTO = expedienteClinicoMapper.toExpedienteClinicoDTO(expedienteClinico);
        return expedienteClinicoDTO;
    }

    @Override
    public void actualizarExpedienteClinico(ExpedienteClinicoDTO expedienteClinicoDTO) {
        expedienteClinicoRepository.save(expedienteClinicoMapper.toExpedienteClinico(expedienteClinicoDTO));
    }

    @Override
    public void borrarExpedienteClinico(Long idExpedienteClinico) {
        expedienteClinicoRepository.deleteById(idExpedienteClinico);
    }
}
