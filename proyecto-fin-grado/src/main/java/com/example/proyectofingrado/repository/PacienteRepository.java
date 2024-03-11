package com.example.proyectofingrado.repository;

import com.example.proyectofingrado.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
Paciente findById(int idPaciente);
    Paciente deleteById(int idPaciente);

}
