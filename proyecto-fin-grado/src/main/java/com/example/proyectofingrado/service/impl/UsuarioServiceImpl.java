package com.example.proyectofingrado.service.impl;

import com.example.proyectofingrado.dto.UsuarioDTO;
import com.example.proyectofingrado.entity.Role;
import com.example.proyectofingrado.entity.User;
import com.example.proyectofingrado.repository.RoleRepository;
import com.example.proyectofingrado.repository.UserRepository;
import com.example.proyectofingrado.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

   private UserRepository userRepository;
   private RoleRepository roleRepository;
   private PasswordEncoder passwordEncoder;
    public UsuarioServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        User user = new User();
        user.setName(usuarioDTO.getFirstName() + " " + usuarioDTO.getLastName());
        user.setEmail(usuarioDTO.getEmail());
       //ENCRIPTAMOS con spring security: (password encoder)
        user.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

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

    @Override
    public List<UsuarioDTO> findAllUsers() {
            List<User> users = userRepository.findAll();
            return users.stream().map((user) -> mapToUserDTO(user)).collect(Collectors.toList());
    }

    private UsuarioDTO mapToUserDTO(User user){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        String[]str = user.getName().split(" ");
        usuarioDTO.setFirstName(str[0]);
        usuarioDTO.setLastName(str[1]);
        usuarioDTO.setEmail(user.getEmail());

        return usuarioDTO;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
