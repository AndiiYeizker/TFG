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


/**Crear expediente**/
    @Override
    public void guardarExpedienteClinico(int idPaciente, ExpedienteClinicoDTO expedienteClinicoDTO) {
        Paciente paciente = pacienteRepository.findById((long) idPaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        expedienteClinicoDTO.setPaciente(paciente);
        ExpedienteClinico expedienteClinico = ExpedienteClinicoMapper.toExpedienteClinico(expedienteClinicoDTO);
        expedienteClinicoRepository.save(expedienteClinico);
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

/**METODOS DE DEVOLVER EXPEDIENTES**/
/**todos los expedientes*/
    @Override
    public List<ExpedienteClinicoDTO> obtenerExpedientesClinicos() {
        List<ExpedienteClinico> expedienteClinicoList = expedienteClinicoRepository.findAll();
       List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoList.stream().map((expediente) ->
               ExpedienteClinicoMapper.toExpedienteClinicoDTO(expediente)).collect(Collectors.toList());
       return expedienteClinicoDTOList;
    }

    /**todos los expedientes de un paciente**/
    @Override
    public List<ExpedienteClinicoDTO> obtenerListaExpedientesClinicosPorPaciente(int idPaciente) {
        Paciente paciente = pacienteRepository.findById((long) idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        List<ExpedienteClinico> expedienteClinicoList = expedienteClinicoRepository.findByPaciente(paciente);
        List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoList.stream().map((expedienteClinico) -> ExpedienteClinicoMapper.toExpedienteClinicoDTO(expedienteClinico))
                .collect(Collectors.toList());
        return expedienteClinicoDTOList;
    }

/**Un único expediente de un paciente**/
    @Override
    public ExpedienteClinicoDTO obtenerExpedienteClinicoPorPaciente(int idPaciente, int idExpediente) {
        Paciente paciente = pacienteRepository.findById((long) idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        ExpedienteClinico expedienteClinico = expedienteClinicoRepository.findByIdAndPaciente(idExpediente,paciente);
        ExpedienteClinicoDTO expedienteClinicoDTO = ExpedienteClinicoMapper.toExpedienteClinicoDTO(expedienteClinico);
        return expedienteClinicoDTO;
    }

    /**Parte de las graficas**/
    @Override
    public void aceptarExpediente(int idExpediente) {
        ExpedienteClinico expediente = expedienteClinicoRepository.findById((long) idExpediente)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado con ID: " + idExpediente));

        expediente.setAceptado(true);
        expedienteClinicoRepository.save(expediente);
    }
}
