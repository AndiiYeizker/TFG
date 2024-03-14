package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.PacienteDTO;
import com.example.proyectofingrado.dtoRespuestas.EnfermedadDTO;
import com.example.proyectofingrado.service.EnfermedadService;
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

/**Crear enfermedades o borrarlas será trabajo de un administrador del sistema**/
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

    // Página web de crear enfermedad
    @GetMapping("/enfermedades/crear")
    public String crearEnfermedad(Model model) {
        EnfermedadDTO enfermedadDTO = new EnfermedadDTO();
        model.addAttribute("enfermedad", enfermedadDTO);
        return "crear_enfermedad";
    }

    // Guarda una enfermedad
    @PostMapping("/enfermedades")
    public String guardarEnfermedad(@ModelAttribute("enfermedad") EnfermedadDTO enfermedadDTO) {
        enfermedadService.guardarEnfermedad(enfermedadDTO);
        return "redirect:/enfermedades";
    }

    /** Actualizar Enfermedades en la base de datos
    // Página web de actualizar los datos de una enfermedad
    @GetMapping("/enfermedades/{idEnfermedad}/actualizar")
    public String actualizarEnfermedad(@PathVariable("idEnfermedad") String idEnfermedad, Model model) {
        EnfermedadDTO enfermedadDTO = enfermedadService.getEnfermedadById(idEnfermedad);
        model.addAttribute("enfermedad", enfermedadDTO);
        return "actualizar_enfermedad";
    }

    // Método para actualizar info de las enfermedades
    @PostMapping("/enfermedades/{idEnfermedad}")
    public String actualizarEnfermedad(@PathVariable("idEnfermedad") int idEnfermedad, @Valid @ModelAttribute("enfermedad")
    EnfermedadDTO enfermedadDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("enfermedad", enfermedadDTO);
            return "actualizar_enfermedad";
        }
        enfermedadDTO.setId(idEnfermedad);
        enfermedadService.actualizarEnfermedad(enfermedadDTO);

        return "redirect:/enfermedades";
    }

    // Borrar enfermedades (botón borrar)
    @GetMapping("enfermedades/{idEnfermedad}/borrar")
    public String borrarEnfermedad(@PathVariable("idEnfermedad") int idEnfermedad){
        enfermedadService.borrarEnfermedad(idEnfermedad);
        return "redirect:/enfermedades";
    }

    // Página de ver enfermedad (para botón ver enfermedad)
    @GetMapping("/enfermedades/{idEnfermedad}/ver")
    public String verEnfermedad(@PathVariable("idEnfermedad") int idEnfermedad,
                                Model model){
        EnfermedadDTO enfermedadDTO = enfermedadService.getEnfermedadById(idEnfermedad);
        model.addAttribute("enfermedad", enfermedadDTO);
        return "ver_enfermedad";
    }
     **/
}
