package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
 private PacienteService pacienteService;

//Devuelve Lista de todos los pacientes
    @GetMapping("/pacientes")
    public String listaPacientes(Model model){
        List<PacienteDTO> pacienteDTOList = pacienteService.obtenerPacientes();
        model.addAttribute("pacientes",pacienteDTOList);
        return "pacientes";
    }

    //pagina web de crear pacientes
    @GetMapping("/pacientes/crear")
    public String crearPaciente(Model model){
        PacienteDTO pacienteDTO = new PacienteDTO();
        model.addAttribute("paciente",pacienteDTO);
        return "crear_paciente";
    }

    //Guarda un paciente
    @PostMapping("/pacientes")
    public String guardarPaciente(@ModelAttribute("paciente") PacienteDTO pacienteDTO){ //model attribute es el th:object del html
        pacienteService.guardarPaciente(pacienteDTO);
        //pagina a la que se nos redirige al crearlo (cambiarla por pagina de "mi info completada"
        return "redirect:/pacientes";
    }
}
