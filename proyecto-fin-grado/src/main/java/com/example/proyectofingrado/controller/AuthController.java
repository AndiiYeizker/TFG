package com.example.proyectofingrado.controller;

import com.example.proyectofingrado.dtoPeticiones.UsuarioDTO;
import com.example.proyectofingrado.entity.User;
import com.example.proyectofingrado.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        UsuarioDTO user = new UsuarioDTO();
        model.addAttribute("user",user); //variable " la coge el html

        return "registro"; //nombre del html
    }

    //Endpoint para login submit request
    @PostMapping("/registro/guardar")
    public String registro(@Valid @ModelAttribute("user") UsuarioDTO usuarioDTO,
                           BindingResult result,
                           Model model){

        User usuarioExistente = usuarioService.findUserByEmail(usuarioDTO.getEmail());

        if(usuarioExistente!=null){
            result.rejectValue("email", null,"Ya existe este email");
        }
        if(result.hasErrors()){
            model.addAttribute("user",usuarioDTO);
            return "/registro";
        }
        usuarioService.guardarUsuario(usuarioDTO);
        return "redirect:/registro?success";
    }

    // para lista de usuarios
    @GetMapping("/users")
    public String users(Model model){
        List<UsuarioDTO> users = usuarioService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }
}
