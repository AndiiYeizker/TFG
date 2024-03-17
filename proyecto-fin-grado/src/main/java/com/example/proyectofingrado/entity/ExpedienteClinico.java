package com.example.proyectofingrado.entity;

import com.example.proyectofingrado.mapper.ExpedienteClinicoMapper;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "expedienteClinico")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = ExpedienteClinicoMapper.class)
public class ExpedienteClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPacienteList")
    private Paciente paciente;

    /**Rellenado por el paciente*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedad")
    private Enfermedad enfermedad;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioSintomas;

    /** Constructor para mostrar la info*/
    public ExpedienteClinico(Enfermedad enfermedad, Date fechaInicioSintomas) {
        this.enfermedad = enfermedad;
        this.fechaInicioSintomas = fechaInicioSintomas;
    }

    public ExpedienteClinico(int id, Paciente paciente, Enfermedad enfermedad, Date fechaInicioSintomas, int diasIncubacion, int diasInfeccion, int diasTotales, boolean aceptado) {
        this.id = id;
        this.paciente = paciente;
        this.enfermedad = enfermedad;
        this.fechaInicioSintomas = fechaInicioSintomas;
        this.diasIncubacion = diasIncubacion;
        this.diasInfeccion = diasInfeccion;
        this.diasTotales = diasTotales;
        this.aceptado = false;
    }

    //cambiará según la fecha. hay que ver si dejamos la fecha del calendario o si el paciente
    //actualiza su estado, que se actualice tambiéne estadoSeird. Eso sería lo mejor.
   // private t_estadoSEIRD estadoSEIRD;


    /** Esto será la cuenta total de días que haga el paciente. Lo metemos en actualizar enferemdad.
     * Después, mendiante revisado, El medico marcará este historico como aceptado o no y
     * estos datos pasaran a Modelo SEIRD  Pueden ser opcionales, algunos pueden ir a null si no se saben*/
    private int diasIncubacion; //si se sabe el día que tuvo contacto hasta el dia de comienzo sintomas
    private int diasInfeccion; //dias con sintomas
    private int diasTotales; //desde contacto hasta que no hay síntomas


    //true = el medico ha pasado consulta y pasa los datos a graficas oficiales, false: solo es para que la persona lo consulte
    //estado por defecto es false
    private boolean aceptado;


}
