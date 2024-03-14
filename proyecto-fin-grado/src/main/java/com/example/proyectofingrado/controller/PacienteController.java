package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.ExpedienteClinicoDTO;
import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.service.ExpedienteClinicoService;
import com.example.proyectofingrado.service.PacienteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    ExpedienteClinicoService expedienteClinicoService;
    //Pagia visual que contiene Lista de todos los pacientes
    /**
    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDTO>> listaPacientes() {
        List<PacienteDTO> pacienteDTOList = pacienteService.obtenerPacientes();
        return new ResponseEntity<>(pacienteDTOList, HttpStatus.OK);
    }
**/

    @GetMapping("/pacientes")
    public String listaPacientes(Model model) {
        List<PacienteDTO> pacienteDTOList = pacienteService.obtenerPacientes();
        model.addAttribute("pacientes", pacienteDTOList);
        return "pacientes";
    }


    @GetMapping("/pacientes-expedientes")
    public void getPacientesExpedientes(HttpServletResponse response) throws IOException {
        // Cargar el archivo HTML desde la carpeta resources
        Resource resource = new ClassPathResource("templates/pacientes_expedientes.html");

        // Leer el contenido del archivo HTML
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        String htmlContent = new String(bytes);

        // Configurar el tipo de contenido de la respuesta
        response.setContentType("text/html");

        // Escribir el contenido del archivo HTML en la respuesta
        response.getWriter().write(htmlContent);
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
