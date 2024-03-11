package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.Enfermedad;
import com.example.proyectofingrado.entity.ExpedienteClinico;
import com.example.proyectofingrado.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpedienteClinicoRepository extends JpaRepository<ExpedienteClinico, Long> {
    List<ExpedienteClinico> findByPaciente(Paciente paciente);
}
