package com.example.proyectofingrado.security;

import com.example.proyectofingrado.entity.User;
import com.example.proyectofingrado.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //metodo por defecto
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(usernameOrEmail); //puede ser tanto el nombre como el email
        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getEmail()
                    , user.getPassword(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Email o contraseña no validos");
        }
    }
}
