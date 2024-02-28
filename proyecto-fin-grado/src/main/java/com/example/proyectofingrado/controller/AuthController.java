package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dto.UsuarioDTO;
import com.example.proyectofingrado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //gestionar la pagina de login:
   @GetMapping("/index")
    public String home(){
        return "index"; //nombre del html
    }

    //gestionar el registro de usuarios
    @GetMapping("/registro")
    public String registrationForm(Model model){
        //creacion de objeto modelo
        UsuarioDTO usuario = new UsuarioDTO();
        model.addAttribute("usuario",usuario); //variable " la coge el html

        return "registro"; //nombre del html
    }

    //Endpoint para login submit request
@PostMapping("/registro/guardar")
    public String registro(@ModelAttribute("usuario") UsuarioDTO usuarioDTO){
        usuarioService.guardarUsuario(usuarioDTO);
        return "redirect:/registro?success";
   }


    }
