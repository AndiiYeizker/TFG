package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.entity.ExpedienteClinico;
import com.example.proyectofingrado.service.ExpedienteClinicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ExpedienteClinicoController {

@Autowired
    ExpedienteClinicoService expedienteClinicoService;

//cambiar idPaciente forzado por el id de sesion de login asociado

    @GetMapping("/pacientes/{idPaciente}/expedientes")
    public String listarExpedientesClinicos(@PathVariable int idPaciente, Model model) {
        List<ExpedienteClinicoDTO> expedientes = expedienteClinicoService.obtenerExpedienteClinicosPorPaciente(idPaciente);
        model.addAttribute("expedientes", expedientes);

        return "pacientes_expedientes";
    }
}
