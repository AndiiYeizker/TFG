package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dto.UsuarioDTO;
import org.springframework.stereotype.Service;


public interface UsuarioService {
    void guardarUsuario(UsuarioDTO usuarioDTO);
}
