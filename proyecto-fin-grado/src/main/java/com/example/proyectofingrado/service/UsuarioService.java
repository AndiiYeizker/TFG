package com.example.proyectofingrado.service;

import com.example.proyectofingrado.dtoPeticiones.UsuarioDTO;
import com.example.proyectofingrado.entity.User;

import java.util.List;


public interface UsuarioService {
    void guardarUsuario(UsuarioDTO usuarioDTO);

    User findUserByEmail(String email);
    List<UsuarioDTO> findAllUsers();
}
