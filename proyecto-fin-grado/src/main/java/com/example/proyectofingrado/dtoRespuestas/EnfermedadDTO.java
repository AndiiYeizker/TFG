package com.example.proyectofingrado.dtoRespuestas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnfermedadDTO {

    private String nombre;
    private String tipoContagio;
    private String recomendacion; //NO SE VE EN LA WEB
    private String sintomas;
    private String vacunasDisponibles;
    private String testDeteccion;
}
