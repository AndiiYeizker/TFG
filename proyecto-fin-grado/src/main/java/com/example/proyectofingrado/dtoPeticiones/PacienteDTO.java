package com.example.proyectofingrado.dtoPeticiones;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private Long id;

 //   @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    private String apellidos;

  //  @NotNull(message = "La fecha de nacimiento no puede estar vacía")
  //@Temporal(TemporalType.DATE)
    //private Date fechaNacimiento;

 //   @NotNull(message = "La edad no puede estar vacía")
    @Positive(message = "La edad debe ser un número positivo")
    private int edad;

  //  @NotNull(message = "El peso no puede estar vacío")
    @Positive(message = "El peso debe ser un número positivo")
    private double peso;

  //  @NotNull(message = "La altura no puede estar vacía")
    @Positive(message = "La altura debe ser un número positivo")
    private double altura;

   // @NotNull(message = "El sexo no puede estar vacio")
   // @Column(nullable = false)
    private String sexo;

  //  @NotNull(message = "El pais no puede estar vacio")
    private String pais;


}
