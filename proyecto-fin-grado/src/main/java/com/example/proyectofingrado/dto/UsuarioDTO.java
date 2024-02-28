package com.example.proyectofingrado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String firstName;
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String lastName;
    @NotEmpty(message = "El email no puede estar vacío")
    @Email
    private String email;
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;

}
