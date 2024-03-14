package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;
import com.example.proyectofingrado.service.ExpedienteClinicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import jakarta.validation.Valid;

@Controller
public class ExpedienteClinicoController {

@Autowired
    ExpedienteClinicoService expedienteClinicoService;

    // Página visual que contiene la lista de todos los expedientes clínicos
    @GetMapping("/expedientes")
    public String listaExpedientesClinicos(Model model) {
        List<ExpedienteClinicoDTO> expedienteClinicoDTOList = expedienteClinicoService.obtenerExpedientesClinicos();
        model.addAttribute("expedientes", expedienteClinicoDTOList);
        return "expedientes";
    }

    // Página web para crear un expediente clínico
    @GetMapping("/expedientes/crear")
    public String crearExpedienteClinico(Model model) {
        ExpedienteClinicoDTO expedienteClinicoDTO = new ExpedienteClinicoDTO();
        model.addAttribute("expediente", expedienteClinicoDTO);
        return "crear_expediente";
    }

    // Guarda un expediente clínico
    @PostMapping("/expedientes")
    public String guardarExpedienteClinico(@ModelAttribute("expediente") ExpedienteClinicoDTO expedienteClinicoDTO) {
        expedienteClinicoService.guardarExpedienteClinico(expedienteClinicoDTO.getIdPaciente().getId(), expedienteClinicoDTO);
        return "redirect:/expedientes";
    }

    // Página web para actualizar los datos de un expediente clínico
    @GetMapping("/expedientes/{idExpediente}/actualizar")
    public String actualizarExpedienteClinico(@PathVariable("idExpediente") int idExpediente, Model model) {
        ExpedienteClinicoDTO expedienteClinicoDTO = expedienteClinicoService.getExpedienteClinicoById(idExpediente);
        model.addAttribute("expediente", expedienteClinicoDTO);
        return "actualizar_expediente";
    }

    // Método para actualizar la información de un expediente clínico
    @PostMapping("/expedientes/{idExpediente}")
    public String actualizarExpedienteClinico(@PathVariable("idExpediente") int idExpediente, @Valid @ModelAttribute("expediente")
    ExpedienteClinicoDTO expedienteClinicoDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("expediente", expedienteClinicoDTO);
            return "actualizar_expediente";
        }
        expedienteClinicoDTO.setId(idExpediente);
        expedienteClinicoService.actualizarExpedienteClinico(expedienteClinicoDTO);

        return "redirect:/expedientes";
    }

    // Borrar un expediente clínico (botón borrar)
    @GetMapping("expedientes/{idExpediente}/borrar")
    public String borrarExpedienteClinico(@PathVariable("idExpediente") int idExpediente){
        expedienteClinicoService.borrarExpedienteClinico(idExpediente);
        return "redirect:/expedientes";
    }

    // Página de ver expediente clínico (para botón ver expediente clínico)
    @GetMapping("/expedientes/{idExpediente}/ver")
    public String verExpedienteClinico(@PathVariable("idExpediente") int idExpediente,
                                       Model model){
        ExpedienteClinicoDTO expedienteClinicoDTO = expedienteClinicoService.getExpedienteClinicoById(idExpediente);
        model.addAttribute("expediente", expedienteClinicoDTO);
        return "ver_expediente";
    }
}
