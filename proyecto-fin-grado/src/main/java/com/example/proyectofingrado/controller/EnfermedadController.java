package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.dtoRespuestas.EnfermedadDTO;
import com.example.proyectofingrado.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EnfermedadController {

    @Autowired
    EnfermedadService enfermedadService;

    //Pagina visual con la lista de enfermedades disponibles en BD
    @GetMapping("/enfermedades")
    public String listaEnfermedades(Model model) {
        List<EnfermedadDTO> enfermedadDTOList = enfermedadService.obtenerEnfermedads();
        model.addAttribute("enfermedades", enfermedadDTOList);
        return "enfermedades";
    }

}
