package com.example.proyectofingrado.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expedienteClinico")
public class ExpedienteClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idPaciente;

    private Enfermedad enfermedad;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioSintomas;

    private t_estadoSEIRD estadoSEIRD;

    //true = el medico ha pasado consulta y pasa los datos a graficas oficiales, false: solo es para que la persona lo consulte
    //estado por defecto es false
    private boolean revisado;

    /** Estos será la cuenta total de días. El medico marcará este historico como aceptado o no y
     * estos datos pasaran a Modelo SEIRD  Pueden ser opcionales, algunos pueden ir a null si no se saben*/
    private int diasInfeccion;
    private int diasIncubacion;
    private int diasTotales;


}
