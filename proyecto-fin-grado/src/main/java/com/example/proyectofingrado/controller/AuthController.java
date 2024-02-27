package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dto.RegistroUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    //gestionar la pagina de login:
   @GetMapping("/index")
    public String home(){
        return "index"; //nombre del html
    }

    //gestionar el registro de usuarios
    @GetMapping("/registro")
    public String registrationForm(Model model){
        //creacion de objeto modelo
        RegistroUserDTO usuario = new RegistroUserDTO();
        model.addAttribute("usuario",usuario); //variable " la coge el html

        return "registro"; //nombre del html
    }
}
