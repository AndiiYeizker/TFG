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
    @Autowired
    EnfermedadMapper enfermedadMapper;

    @Override
    public void guardarEnfermedad(EnfermedadDTO EnfermedadDTO) {
        Enfermedad Enfermedad = enfermedadMapper.toEnfermedad(EnfermedadDTO);
        enfermedadRepository.save(Enfermedad);
    }

    @Override
    public List<EnfermedadDTO> obtenerEnfermedads() {
        List<Enfermedad> EnfermedadList = enfermedadRepository.findAll();
        List<EnfermedadDTO> EnfermedadDTOList = EnfermedadList.stream().map((enfermedad) -> enfermedadMapper.toEnfermedadDTO(enfermedad))
                .collect(Collectors.toList());

        return EnfermedadDTOList;
    }

    @Override
    public EnfermedadDTO getEnfermedadById(Long idEnfermedad) {
        Enfermedad Enfermedad = enfermedadRepository.findById(idEnfermedad).get();
        EnfermedadDTO EnfermedadDTO = enfermedadMapper.toEnfermedadDTO(Enfermedad);
        return EnfermedadDTO;
    }

    @Override
    public void actualizarEnfermedad(EnfermedadDTO EnfermedadDTO) {
        enfermedadRepository.save(EnfermedadMapper.toEnfermedad(EnfermedadDTO));
    }

    @Override
    public void borrarEnfermedad(Long idEnfermedad) {
        enfermedadRepository.deleteById(idEnfermedad);
    }
}
