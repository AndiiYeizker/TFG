package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;
import com.example.proyectofingrado.entity.Paciente;
import com.example.proyectofingrado.service.EnfermedadService;
import com.example.proyectofingrado.service.ExpedienteClinicoService;
import com.example.proyectofingrado.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@Controller
public class ExpedienteClinicoController {

@Autowired
    ExpedienteClinicoService expedienteClinicoService;

@Autowired
    EnfermedadService enfermedadService;

    @Autowired
    private PacienteService pacienteService;

    // Página visual que contiene la lista de todos los expedientes clínicos
    @GetMapping("/expedientes")
    public String listaExpedientesClinicos(Model model) {
        List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoService.obtenerExpedientesClinicos();
        model.addAttribute("expedientes", expedienteClinicoDTOList);
        return "expedientes";
    }

    // Página web para crear un expediente clínico
    @GetMapping("/expedientes/crear/{idPaciente}")
    public String crearExpedienteClinico(@PathVariable Long idPaciente, Model model) {
        ExpedienteClinicoDTO expedienteClinicoDTO = new ExpedienteClinicoDTO();
        Paciente paciente = pacienteService.obtenerPacientePorId(idPaciente);

        // Verificar si el paciente es null o no
        if (paciente != null) {
            expedienteClinicoDTO.setPaciente(paciente);
        } else {
            // Manejar la situación si el paciente no existe
            // Aquí podrías lanzar una excepción, redirigir a una página de error, etc.
        }

        model.addAttribute("expediente", expedienteClinicoDTO);

        List<String> nombresEnfermedades = enfermedadService.obtenerNombresEnfermedades();
        model.addAttribute("nombresEnfermedades", nombresEnfermedades);
        return "expediente_crear";
    }



    //Guarda un expediente clinico y redirecciona a ver paciente
    @PostMapping("/expedientes/crear/{idPaciente}")
    public String guardarExpedienteClinico(@PathVariable Long idPaciente,@ModelAttribute("expediente") ExpedienteClinicoDTO expedienteClinicoDTO) {//model attribute es el th:object del html
        expedienteClinicoService.guardarExpedienteClinico(Math.toIntExact(idPaciente),expedienteClinicoDTO);
        return "redirect:/ver_paciente";
    }

    @GetMapping("/expedientes/{idExpediente}/aceptar")
    public String aceptarExpedienteClinico(@PathVariable("idExpediente") int idExpediente) {
        expedienteClinicoService.aceptarExpediente(idExpediente);
        return "redirect:/pacientes";
    }
    /** Página web para actualizar los datos de un expediente clínico*/
    //en el futuro poner que la lsita de enfermedades traiga solo las que tengan estado seird de infeccion
    @GetMapping("/expedientes/{idExpediente}/actualizar")
    public String actualizarExpedienteClinico(@PathVariable("idExpediente") int idExpediente, Model model) {
        ExpedienteClinicoDTO expedienteClinicoDTO = expedienteClinicoService.getExpedienteClinicoById(idExpediente);
        List<String> nombresEnfermedades = enfermedadService.obtenerNombresEnfermedades();

        model.addAttribute("nombresEnfermedades", nombresEnfermedades);
        model.addAttribute("expediente", expedienteClinicoDTO);
        return "expediente_actualizar";
    }

    // Método para actualizar la información de un expediente clínico
    @PostMapping("/expedientes/{idExpediente}")
    public String actualizarExpedienteClinico(@PathVariable("idExpediente") int idExpediente, @Valid @ModelAttribute("expediente")
    ExpedienteClinicoDTO expedienteClinicoDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("expediente", expedienteClinicoDTO);
            return "expediente_actualizar";
        }
        expedienteClinicoDTO.setId(idExpediente);
        expedienteClinicoService.actualizarExpedienteClinico(expedienteClinicoDTO);

        return "redirect:/pacientes";
    }

    // Borrar un expediente clínico (botón borrar)
    @GetMapping("expedientes/{idExpediente}/borrar")
    public String borrarExpedienteClinico(@PathVariable("idExpediente") int idExpediente){
        expedienteClinicoService.borrarExpedienteClinico(idExpediente);
        return "redirect:/pacientes";
    }

    // Página de ver expediente clínico (para botón ver expediente clínico)
    @GetMapping("/expedientes/{idPaciente}/{idExpediente}/ver")
    public String verExpedienteClinico(@PathVariable("idPaciente") int idPaciente,
                                       @PathVariable("idExpediente") int idExpediente,
                                       Model model){
        ExpedienteClinicoDTO expedienteClinicoDTO = expedienteClinicoService.obtenerExpedienteClinicoPorPaciente(idPaciente,idExpediente);
        model.addAttribute("expediente", expedienteClinicoDTO);
        return "expediente_ver";
    }
}
