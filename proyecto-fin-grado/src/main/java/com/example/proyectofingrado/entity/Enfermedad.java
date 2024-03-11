package com.example.proyectofingrado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enfermedad")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //falta etiqueta de inmutable
    private Long nombre;

    /** INFORMACION DE LA ENFERMEDAD para el paciente*/
    //si hubiera tiempo estaría guay que fuera una lista de tipos
    private String tipoContagio;
    private String recomendacion;
    private String sintomas;
    private String vacunasDisponibles;
    private String testDeteccion;

    /** DURACIONES Datos calculados con la media de todos los pacientes. Serán científicos de carga inicial
     * hasta que se haya realizado la parte del ajuste**/

    //hay que mirar de donde a donde comprendería...
    private int duracionIncubacion;
    private int duracionSintomas;
    private int duracionContagio;
    private int duracionInmunidad;
    private int duracionTotal;

    /** TASAS */
    private double tasaMortalidad;
    private double tasaRecuperacion;
    private double tasaTransmision;
    private double tasaExposicion;

/** Constructor visual de la info de enfermedades*/
public Enfermedad(Long nombre, String tipoContagio, String recomendacion, String sintomas, String vacunasDisponibles, String testDeteccion) {
    this.nombre = nombre;
    this.tipoContagio = tipoContagio;
    this.recomendacion = recomendacion;
    this.sintomas = sintomas;
    this.vacunasDisponibles = vacunasDisponibles;
    this.testDeteccion = testDeteccion;
}


}
