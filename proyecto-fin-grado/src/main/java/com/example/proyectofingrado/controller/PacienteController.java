package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
 private PacienteService pacienteService;

//Lista de todos los pacientes
    @GetMapping("/pacientes")
    public String listaPacientes(Model model){
        List<PacienteDTO> pacienteDTOList = pacienteService.obtenerPacientes();
        model.addAttribute("pacientes",pacienteDTOList);
        return"pacientes";
    }


    @GetMapping("/pacientes/crear")
    public String crearPaciente(Model model){
        //objeto modelo de paciente para recoger sus datos
        PacienteDTO pacienteDTO = new PacienteDTO();
        model.addAttribute("paciente",pacienteDTO);
        return"crear_paciente";
    }
}
