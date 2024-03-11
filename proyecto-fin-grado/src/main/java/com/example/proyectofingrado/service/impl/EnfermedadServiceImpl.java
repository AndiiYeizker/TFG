package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dtoRespuestas.EnfermedadDTO;
import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.mapper.EnfermedadMapper;
import com.example.proyectofingrado.repository.EnfermedadRepository;
import com.example.proyectofingrado.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    EnfermedadRepository enfermedadRepository;


    @Override
    public void guardarEnfermedad(EnfermedadDTO enfermedadDTO) {
        Enfermedad enfermedad = EnfermedadMapper.toEnfermedad(enfermedadDTO);
        enfermedadRepository.save(enfermedad);
    }

    @Override
    public List<EnfermedadDTO> obtenerEnfermedads() {
        List<Enfermedad> enfermedadList = enfermedadRepository.findAll();
        List<EnfermedadDTO> enfermedadDTOList = enfermedadList.stream().map((enfermedad) -> EnfermedadMapper.toEnfermedadDTO(enfermedad))
                .collect(Collectors.toList());

        return enfermedadDTOList;
    }

    @Override
    public EnfermedadDTO getEnfermedadById(Long idEnfermedad) {
        Enfermedad enfermedad = enfermedadRepository.findById(idEnfermedad).get();
        EnfermedadDTO EnfermedadDTO = EnfermedadMapper.toEnfermedadDTO(enfermedad);
        return EnfermedadDTO;
    }

    @Override
    public void actualizarEnfermedad(EnfermedadDTO enfermedadDTO) {
        enfermedadRepository.save(EnfermedadMapper.toEnfermedad(enfermedadDTO));
    }

    @Override
    public void borrarEnfermedad(Long idEnfermedad) {
        enfermedadRepository.deleteById(idEnfermedad);
    }

}
