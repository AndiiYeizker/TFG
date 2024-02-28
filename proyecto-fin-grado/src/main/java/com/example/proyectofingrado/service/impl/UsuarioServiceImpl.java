package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dto.UsuarioDTO;
import com.example.proyectofingrado.entity.Role;
import com.example.proyectofingrado.entity.User;
import com.example.proyectofingrado.repository.RoleRepository;
import com.example.proyectofingrado.repository.UserRepository;
import com.example.proyectofingrado.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsuarioServiceImpl implements UsuarioService {

   private UserRepository userRepository;
   private RoleRepository roleRepository;
    public UsuarioServiceImpl(UserRepository userRepository, RoleRepository roleRepository ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        User user = new User();
        user.setName(usuarioDTO.getFirstName() + " " + usuarioDTO.getLastName());
        user.setEmail(usuarioDTO.getEmail());
       //ENCRIPTAMOS con spring security:
        user.setPassword(usuarioDTO.getPassword());

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role ==null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
