package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    //Pagia visual que contiene Lista de todos los pacientes
    @GetMapping("/pacientes")
    public String listaPacientes(Model model) {
        List<PacienteDTO> pacienteDTOList = pacienteService.obtenerPacientes();
        model.addAttribute("pacientes", pacienteDTOList);
        return "pacientes";
    }

    //pagina web de crear pacientes
    @GetMapping("/pacientes/crear")
    public String crearPaciente(Model model) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        model.addAttribute("paciente", pacienteDTO);
        return "crear_paciente";
    }

    //Guarda un paciente
    @PostMapping("/pacientes")
    public String guardarPaciente(@ModelAttribute("paciente") PacienteDTO pacienteDTO) { //model attribute es el th:object del html
        pacienteService.guardarPaciente(pacienteDTO);
        //pagina a la que se nos redirige al crearlo (cambiarla por pagina de "mi info completada"
        return "redirect:/pacientes";
    }

    //Pagina web de actualizar los datos de un paciente
    @GetMapping("/pacientes/{idPaciente}/actualizar")
    public String actualizarPaciente(@PathVariable("idPaciente") int idPaciente, Model model) {
        PacienteDTO pacienteDTO = pacienteService.getPacienteById(idPaciente);
        model.addAttribute("paciente", pacienteDTO);
        return "actualizar_paciente";
    }

    //metodo para actualizar info de los pacientes
    @PostMapping("/pacientes/{idPaciente}") //url que he puesto en th:action
    public String actualizarPaciente(@PathVariable("idPaciente") int idPaciente, @Valid @ModelAttribute("paciente")
    PacienteDTO pacienteDTO, BindingResult result, Model model) { //model attribute es el th:object del html

        if (result.hasErrors()) {
            model.addAttribute("paciente", pacienteDTO);
            return "actualizar_paciente";
        }
        pacienteDTO.setId(idPaciente);
        pacienteService.actualizarPaciente(pacienteDTO);

        return "redirect:/pacientes";
    }

    //borrar pacientes (boton borrar)
    @GetMapping("pacientes/{idPaciente}/borrar")
    public String borrarPaciente(@PathVariable("idPaciente") int idPaciente){
        pacienteService.borrarPaciente(idPaciente);
        return "redirect:/pacientes";
    }

    ///pagina de ver paciente (para boton ver paciente)
    @GetMapping("/pacientes/{idPaciente}/ver")
    public String verPaciente(@PathVariable("idPaciente") int idPaciente,
                              Model model){
        PacienteDTO pacienteDTO = pacienteService.getPacienteById(idPaciente);
        model.addAttribute("paciente", pacienteDTO);
        return "ver_paciente";
    }
}
