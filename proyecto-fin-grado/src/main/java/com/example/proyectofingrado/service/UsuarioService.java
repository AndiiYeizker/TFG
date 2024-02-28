package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dto.UsuarioDTO;
import com.example.proyectofingrado.entity.User;
import org.springframework.stereotype.Service;


public interface UsuarioService {
    void guardarUsuario(UsuarioDTO usuarioDTO);

    User findUserByEmail(String email);
}
